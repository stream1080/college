package com.stream.college.service.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stream.college.common.utils.dto.MemberDto;
import com.stream.college.common.utils.exception.CollegeException;
import com.stream.college.common.utils.result.ResultCodeEnum;
import com.stream.college.common.utils.util.FormUtils;
import com.stream.college.common.utils.util.JwtInfo;
import com.stream.college.common.utils.util.JwtUtils;
import com.stream.college.common.utils.util.MD5;
import com.stream.college.service.ucenter.entity.Member;
import com.stream.college.service.ucenter.entity.vo.LoginVo;
import com.stream.college.service.ucenter.entity.vo.MemberQueryVo;
import com.stream.college.service.ucenter.entity.vo.RegisterVo;
import com.stream.college.service.ucenter.mapper.MemberMapper;
import com.stream.college.service.ucenter.service.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author stream
 * @since 2022/4/3 20:13
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void register(RegisterVo registerVo) {

        String nickname = registerVo.getNickname();
        String mobile = registerVo.getMobile();
        String email = registerVo.getEmail();
        String password = registerVo.getPassword();
        String code = registerVo.getCode();

        //手机号和邮箱不能同时为空
        if (StringUtils.isEmpty(mobile) && StringUtils.isEmpty(email)) {
            throw new CollegeException(ResultCodeEnum.PARAM_ERROR);
        }

        //优先校验手机，没有手机则校验邮箱
        //注意: 这里需要使用 '|' 要两边都能检测到
        if (!StringUtils.isEmpty(mobile) | FormUtils.isMobile(mobile)) {
            //校验验证码
            String checkCode = redisTemplate.opsForValue().get(mobile).toString();
            if (!code.equals(checkCode)) {
                throw new CollegeException(ResultCodeEnum.CODE_ERROR);
            }
        } else if (!StringUtils.isEmpty(email) | FormUtils.isMobile(email)) {
            //校验验证码
            String checkCode = redisTemplate.opsForValue().get(email).toString();
            if (!code.equals(checkCode)) {
                throw new CollegeException(ResultCodeEnum.CODE_ERROR);
            }
        }

        //是否被注册的条件
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(mobile)) {
            queryWrapper.lambda().eq(Member::getMobile, mobile);
        }
        if (!StringUtils.isEmpty(email)) {
            queryWrapper.lambda().or().eq(Member::getEmail, email);
        }
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new CollegeException(ResultCodeEnum.REGISTER_USER_ERROR);
        }

        //注册
        Member member = new Member();
        member.setNickname(nickname);
        member.setMobile(mobile);
        member.setEmail(email);
        member.setPassword(MD5.encrypt(password));
        member.setDisabled(false);
        //默认头像
        member.setAvatar("https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205056.jpg");
        baseMapper.insert(member);
    }

    @Override
    public String login(LoginVo loginVo) {

        String account = loginVo.getAccount();
        String password = loginVo.getPassword();

        //校验账号是否存在
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Member::getMobile, account).or().eq(Member::getEmail, account);
        Member member = baseMapper.selectOne(queryWrapper);
        if (member == null) {
            throw new CollegeException(ResultCodeEnum.LOGIN_MOBILE_ERROR);
        }

        //校验密码是否正确
        if (!MD5.encrypt(password).equals(member.getPassword())) {
            throw new CollegeException(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
        }

        //校验用户是否被禁用
        if (member.getDisabled()) {
            throw new CollegeException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }

        //登录：生成token
        JwtInfo info = new JwtInfo();
        info.setId(member.getId());
        info.setNickname(member.getNickname());
        info.setAvatar(member.getAvatar());

        return JwtUtils.getJwtToken(info, 1800);

    }

    @Override
    public Member getByOpenid(String openid) {

        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public MemberDto getMemberDtoByMemberId(String memberId) {

        Member member = baseMapper.selectById(memberId);
        MemberDto memberDto = new MemberDto();
        BeanUtils.copyProperties(member, memberDto);
        return memberDto;
    }

    @Override
    public IPage<Member> selectPage(Page<Member> pageParam, MemberQueryVo memberQueryVo) {


        //1、构造查询
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();

        //2、分页查询
        if (memberQueryVo == null) {
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

        //3、条件查询
        String nickname = memberQueryVo.getNickname();
        String email = memberQueryVo.getEmail();
        String mobile = memberQueryVo.getMobile();

        if (!StringUtils.isEmpty(nickname)) {
            queryWrapper.likeRight("nickname", nickname);
        }

        if (!StringUtils.isEmpty(email)) {
            queryWrapper.eq("email", email);
        }

        if (!StringUtils.isEmpty(mobile)) {
            queryWrapper.eq("mobile", mobile);
        }

        Page<Member> memberPage = baseMapper.selectPage(pageParam, queryWrapper);
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < memberPage.getRecords().size(); i++) {
            Member member = memberPage.getRecords().get(i);
            member.setPassword("");
            member.setSign("");
            member.setOpenid("");
            list.add(member);
        }
        memberPage.setRecords(list);

        return memberPage;
    }

    @Override
    public List<Member> listAll() {
        List<Member> members = baseMapper.selectList(null);
        for (int i = 0; i < members.size(); i++) {
            members.get(i).setPassword("");
            members.get(i).setSign("");
            members.get(i).setOpenid("");
        }
        return members;
    }

    @Override
    public boolean editDisableById(String id, boolean isDisable) {
        Member member = baseMapper.selectById(id);
        member.setDisabled(isDisable);
        int i = baseMapper.updateById(member);
        return i==1;
    }

}

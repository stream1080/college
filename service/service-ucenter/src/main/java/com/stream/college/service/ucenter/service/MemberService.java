package com.stream.college.service.ucenter.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.common.utils.dto.MemberDto;
import com.stream.college.service.ucenter.entity.Member;
import com.stream.college.service.ucenter.entity.vo.LoginVo;
import com.stream.college.service.ucenter.entity.vo.MemberQueryVo;
import com.stream.college.service.ucenter.entity.vo.RegisterVo;

import java.util.List;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author stream
 * @since 2022/4/3 20:13
 */
public interface MemberService extends IService<Member> {

    void register(RegisterVo registerVo);

    String login(LoginVo loginVo);

    Member getByOpenid(String openid);

    MemberDto getMemberDtoByMemberId(String memberId);

    IPage<Member> selectPage(Page<Member> pageParam, MemberQueryVo memberQueryVo);

    List<Member> listAll();

    boolean editDisableById(String id,boolean isDisable);

}

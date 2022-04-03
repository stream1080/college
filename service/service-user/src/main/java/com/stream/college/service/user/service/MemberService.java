package com.stream.college.service.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.stream.college.service.user.entity.Member;
import com.stream.college.service.user.entity.vo.LoginVo;
import com.stream.college.service.user.entity.vo.RegisterVo;

/**
 * @author stream
 * @since 2022/4/3 20:13
 */
public interface MemberService extends IService<Member> {

    void register(RegisterVo registerVo);

    String login(LoginVo loginVo);
}

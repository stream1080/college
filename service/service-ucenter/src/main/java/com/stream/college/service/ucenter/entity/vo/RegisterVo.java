package com.stream.college.service.ucenter.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stream
 * @since 2022/4/3 20:13
 */
@Data
public class RegisterVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickname;

    private String mobile;

    private String email;

    private String password;

    private String code;

}
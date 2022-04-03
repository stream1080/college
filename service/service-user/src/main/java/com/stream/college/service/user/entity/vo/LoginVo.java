package com.stream.college.service.user.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stream
 * @since 2022/4/3 20:13
 */
@Data
public class LoginVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mobile;

    private String password;

}
package com.stream.college.service.ucenter.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author stream
 * @since 2022/4/3 20:13
 */
@Data
public class LoginVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "手机号或邮箱不能为空")
    private String account;

    @NotEmpty(message = "密码不能为空")
    private String password;

}
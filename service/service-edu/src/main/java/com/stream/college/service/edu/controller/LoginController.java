package com.stream.college.service.edu.controller;

import com.stream.college.common.utils.result.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author stream
 * @since 2022/2/3 14:52
 */
@RestController
@RequestMapping("/user")
@Api(tags = "登录管理")
public class LoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok()
                .data("token","073eb5d2-f5f4-488a-82ed-aec8a5289a5d");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok()
                .data("name","admin")
                .data("roles","[admin]")
                .data("avatar","https://edu-college.oss-cn-shenzhen.aliyuncs.com/avatar/2020/07/27/20200727205056.jpg");
    }

    @PostMapping("/logout")
    public R logout(){
        return R.ok().message("");
    }

}

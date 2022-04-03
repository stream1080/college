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
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("name","admin").data("roles","[admin]").data("avatar","ss");
    }

}

package com.stream.mooc.service.edu.controller.admin;

import com.stream.mooc.common.util.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author stream
 * @since 2022/2/3 14:52
 */
@RestController
@RequestMapping("/user")
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

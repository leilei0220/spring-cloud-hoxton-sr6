package com.leilei.controller;

import com.leilei.entity.LoginUser;
import com.leilei.feign.LoginFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 15:09
 * @desc
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private final LoginFeign loginFeign;

    @Autowired
    public UserController(LoginFeign loginFeign) {
        this.loginFeign = loginFeign;
    }

    @PostMapping("/login")
    public LoginUser login(@RequestBody LoginUser loginUser) {
        return loginFeign.login(loginUser);
    }
}

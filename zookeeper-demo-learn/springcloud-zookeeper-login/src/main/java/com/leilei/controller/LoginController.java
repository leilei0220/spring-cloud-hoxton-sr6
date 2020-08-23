package com.leilei.controller;

import com.leilei.entity.LoginUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 15:14
 * @desc
 */
@RequestMapping("/login")
@RestController
public class LoginController {
    @PostMapping("/app")
    public LoginUser appLogin(@RequestBody LoginUser loginUser) {
        loginUser.setLoginTime(LocalDateTime.now());
        return loginUser;
    }
}

package com.leilei.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 10:10
 * @desc 注册
 */
@RequestMapping("/register")
@RestController
public class RegisterController {

    @PostMapping("/user/{name}")
    public String register(@PathVariable("name") String name) {
        return "注册成功:" + name;
    }
}

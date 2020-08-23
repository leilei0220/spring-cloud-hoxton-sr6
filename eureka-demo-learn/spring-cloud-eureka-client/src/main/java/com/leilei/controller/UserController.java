package com.leilei.controller;

import com.leilei.feign.RegisterFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 10:04
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController {

   private final RegisterFeign registerFeign;
    @Autowired
    public UserController(RegisterFeign registerFeign) {
        this.registerFeign = registerFeign;
    }

    @PostMapping("/register/{name}")
    public String register(@PathVariable("name") String name) {
        return registerFeign.register(name);
    }
}

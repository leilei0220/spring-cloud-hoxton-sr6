package com.leilei.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 10:04
 * @desc 注册feign
 */
@FeignClient(value = "register-lei")
public interface RegisterFeign {
    @PostMapping("/register/user/{name}")
    String register(@PathVariable("name")String name);
}

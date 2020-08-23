package com.leilei.feign;

import com.leilei.entity.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 15:09
 * @desc
 */
@FeignClient(value = "app-login")
public interface LoginFeign {
    @PostMapping("/login/app")
    LoginUser login(@RequestBody LoginUser loginUser);
}

package com.leilei.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lei
 * @version 1.0
 * @date 2020/10/12 22:14
 * @desc
 */
@RestController
@RequestMapping("/zs")
public class ZSController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String serverName;
    @RequestMapping("/init")
    public String demo() {
        return "zs"+"当前服务名："+ serverName+"端口："+port;
    }
    @RequestMapping("/init/it")
    public String demo2() {
        return "zs"+"当前服务名："+ serverName+"端口："+port;
    }
}

package com.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 17:10
 * @desc 这里是演示 restTemplate 调用此web 接口 拿到返回值
 */
@RestController
public class ProductController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/product/findAll")
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("msg", "服务调用成功,服务提供端口为: " + port);
        map.put("status", true);
        map.put("data", Arrays.asList("zs", "ls"));
        return map;
    }

    @GetMapping("/cloud/findAll")
    public Map<String, Object> findAllCloud() {
        RestTemplate restTemplate = new RestTemplate();
        Map body = restTemplate.getForObject("http://demo-product/dem/cloud", Map.class);
        return body;
    }
}

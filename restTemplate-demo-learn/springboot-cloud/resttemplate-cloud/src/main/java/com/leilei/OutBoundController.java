package com.leilei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 17:22
 * @desc
 */
@RequestMapping("/dem")
@RestController
public class OutBoundController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private int port;

    @GetMapping("/find/all")
    public Map aa() {
        RestTemplate restTemplate = new RestTemplate();
        Map body = restTemplate.getForObject("http://localhost:8081/product/findAll", Map.class);
        return body;
    }

    @GetMapping("/cloud")
    public Map<String, Object> findAllCloud() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("msg", "服务调用成功,当前服务提供端口为: " + port);
        map.put("status", true);
        map.put("data", Arrays.asList("zs-cloud", "ls-cloud"));
        return map;
    }

    @GetMapping("/order/find/all")
    public Map order() {
        Map body = restTemplate.getForObject("http://demo-order/order/all", Map.class);
        return body;
    }
}

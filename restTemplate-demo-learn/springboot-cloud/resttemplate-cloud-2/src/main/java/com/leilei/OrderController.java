package com.leilei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 17:56
 * @desc
 */
@RestController()
@RequestMapping("/order")
public class OrderController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/all")
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("msg", "订单服务调用成功,服务提供端口为: " + port);
        map.put("status", true);
        map.put("data", Arrays.asList("zs-order", "ls-order"));
        return map;
    }
}

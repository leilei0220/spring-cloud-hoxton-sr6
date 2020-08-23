package com.leilei.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 11:02
 * @desc 库存 feign
 */
@FeignClient(value = "service-stock")
public interface StockFeign {
    @GetMapping("/stock/ping/pong/{type}/{num}")
     String buyPingPong(@PathVariable("type") Integer type, @PathVariable("num") Integer num);
}

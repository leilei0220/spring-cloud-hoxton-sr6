package com.leilei.controller;

import com.leilei.feign.StockFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 11:02
 * @desc
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    private final StockFeign stockFeign;

    public ProductController(StockFeign stockFeign) {
        this.stockFeign = stockFeign;
    }

    @GetMapping("/buy/ping/pong/{type}/{num}")
    public String buyPingPong(@PathVariable("type") Integer type, @PathVariable("num") Integer num) {
        return stockFeign.buyPingPong(type,num);
    }
}

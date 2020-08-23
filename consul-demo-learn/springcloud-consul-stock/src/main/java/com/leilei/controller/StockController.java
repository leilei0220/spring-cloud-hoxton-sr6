package com.leilei.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 11:08
 * @desc
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @GetMapping("/ping/pong/{type}/{num}")
    public String pingPongStock(@PathVariable("type") Integer type, @PathVariable("num") Integer num) {
        String pingPongType = type == 1 ? "马龙" : "托马斯回旋";
        return "出库：" + pingPongType + "类型乒乓球" + num + "件，目前库存剩余：" + 66;
    }
}

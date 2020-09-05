package com.leilei.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/30 18:30
 * @desc
 */
@FeignClient(value = "demo-product",fallback = ProductFeignFallback.class)
public interface ProductFeign {

    @GetMapping("/product/demo/{id}")
    Result findProduct(@PathVariable("id") Integer id);

    @GetMapping("/product/demo")
    Result findProductByParam(@RequestParam("id") Integer id, @RequestParam("name")String name);

    @PostMapping("/product")
    Result addProduct(@RequestBody Product product);

    @PutMapping("/product")
    Result editProduct(@RequestBody Product product);

    @DeleteMapping("/product/{id}")
    Result deleteProduct(@PathVariable("id") Integer id);
}

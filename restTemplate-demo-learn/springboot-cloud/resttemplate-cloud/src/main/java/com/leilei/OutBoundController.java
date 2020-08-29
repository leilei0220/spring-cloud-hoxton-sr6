package com.leilei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
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
    private final RestTemplate restTemplate;
    private final RestTemplate cloudRestTemplate;

    @Value("${server.port}")
    private int port;

    @Autowired
    public OutBoundController(RestTemplate cloudRestTemplate, RestTemplate restTemplate) {
        this.cloudRestTemplate = cloudRestTemplate;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/find/all")
    public Map aa() {
        RestTemplate restTemplate = new RestTemplate();
        Map body = restTemplate.getForObject("http://localhost:8081/product/findAll", Map.class);
        return body;
    }
    @GetMapping("/find/GetForEntity")
    public Map learnGetForEntity() {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:8081/product/findAll", Map.class);
        return forEntity.getBody();
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
        Map body = cloudRestTemplate.getForObject("http://demo-order/order/all", Map.class);
        return body;
    }

    @GetMapping("/find/product/{id}/{name}")
    public Result findProductById(@PathVariable("id") Integer id,@PathVariable("name")String name) {
        Product product = new Product();
        product.setId(id);
        product.setProductName(name);
        product.setPrice(new BigDecimal("23.5"));
        return Result.success(product);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product addProduct) {
        addProduct.setId(1);
        return Result.success(addProduct);
    }
    @PostMapping("/add/{price}")
    public Result addPrice(@RequestBody Product addProduct,@PathVariable("price") BigDecimal price) {
        addProduct.setId(666);
        addProduct.setPrice(price);
        return Result.success(addProduct);
    }

    @PutMapping("/put")
    public Result put(@RequestBody Product editProduct) {
        return editProduct.getId() < 1 ? Result.failure() : Result.success(editProduct);
    }


   @DeleteMapping("/product/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        return Result.success("删除成功，id："+id);
    }
}

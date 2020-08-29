package com.boot.controller;

import com.boot.entity.Product;
import com.boot.entity.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
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

    private final RestTemplate restTemplate;

    @Autowired
    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/product/findAll")
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("msg", "boot 单体服务调用成功,服务提供端口为: " + port);
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

    @GetMapping("/find/product/{id}/{name}")
    public Result getById(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9001/dem/find/product/{id}/{name}", Result.class, id, name);
    }


    @GetMapping("/find/exchange/product/{id}/{name}")
    public Result exchangeGet(@PathVariable("id") Integer id, @PathVariable("name") String name) throws URISyntaxException {
        String url = "http://localhost:9001/dem/find/product/{id}/{name}";
        url = url.replace("{id}", id.toString());
        url = url.replace("{name}", name);
        RequestEntity<Object> requestEntity = new RequestEntity<>(null, HttpMethod.GET, new URI(url));
        ParameterizedTypeReference<Result> typeReference = new ParameterizedTypeReference<Result>() {
        };
        return restTemplate.exchange(requestEntity, typeReference).getBody();
    }

    @PostMapping("add")
    public Result addProduct(@RequestBody Product product) {
        ResponseEntity<Result> responseEntity = restTemplate.postForEntity("http://localhost:9001/dem/add", product, Result.class);
        return responseEntity.getBody();
    }

    @PostMapping("add/exchange")
    public Result addProductExchange(@RequestBody Product product) throws URISyntaxException {
        String url = "http://localhost:9001/dem/add";
        RequestEntity<Object> requestEntity = new RequestEntity<>(product, null, HttpMethod.POST, new URI(url));
        ParameterizedTypeReference<Result> typeReference = new ParameterizedTypeReference<Result>() {
        };
        return restTemplate.exchange(requestEntity, typeReference).getBody();
    }

    @PostMapping("addObject")
    public Result addProductObject(@RequestBody Product product) {
        Result result = restTemplate.postForObject("http://localhost:9001/dem/add", product, Result.class);
        return result;

    }

    @PostMapping("addObject/{price}")
    public Result addProductPath(@RequestBody Product product, @PathVariable("price") BigDecimal price) {
        Result result = restTemplate.postForObject("http://localhost:9001/dem/add/{price}", product, Result.class, price);
        return result;
    }

    @PutMapping("put/product")
    public Result putProduct(@RequestBody Product product) {
        try {
            restTemplate.put("http://localhost:9001/dem/put", product);
            return Result.success("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }

    @PutMapping("put/product/exchange")
    public Result putProductExchage(@RequestBody Product product) throws URISyntaxException {

        String url = "http://localhost:9001/dem/put";
        RequestEntity requestEntity = new RequestEntity(product, null, HttpMethod.PUT, new URI(url));
        ParameterizedTypeReference<Result> typeReference = new ParameterizedTypeReference<Result>() {
        };
        ResponseEntity<Result> exchange = restTemplate.exchange(requestEntity, typeReference);
        return exchange.getBody();
    }

    @DeleteMapping("product/{id}")
    public Result delProduct(@PathVariable("id") Integer id) {
        try {
            restTemplate.delete("http://localhost:9001/dem/product/{id}", id);
            return Result.success("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
    @DeleteMapping("product/exchange/{id}")
    public Result delProductExchange(@PathVariable("id") Integer id) throws URISyntaxException {
        String url = "http://localhost:9001/dem/product/{id}";
        url = url.replace("{id}", id.toString());
        RequestEntity requestEntity = new RequestEntity(null, null, HttpMethod.DELETE, new URI(url));
        ParameterizedTypeReference<Result> typeReference = new ParameterizedTypeReference<Result>() {
        };
        return restTemplate.exchange(requestEntity, typeReference).getBody();
    }

}
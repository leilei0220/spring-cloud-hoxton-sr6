package com.leilei.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/30 18:12
 * @desc
 */
@RestController
@Log4j2
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.cloud.consul.discovery.ip-address}")
    private String ip;

    @RequestMapping("/demo/{id}")
    public Result getProduct(HttpServletRequest request, @PathVariable("id") Integer id) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("请求头信息", map);
        return Result.success("商品获取成功：当前商品Id为：" + id + "当前调用商品服务IP 端口" + ip + ":" + port,
                responseMap);
    }

    @RequestMapping("/demo")
    public Result getProductByParam(@RequestParam("id") Integer id, @RequestParam("name")String name) throws InterruptedException {
        log.info("调用成功" + port);
        Thread.sleep(4000L);
        return Result.success("商品获取成功：当前商品Id为：" + id +"商品名为："+name+ "当前调用商品服务IP 端口" + ip + ":" + port);
    }

    @PostMapping
    public Result addProduct(@RequestBody Product product) {
        log.info("添加商品接口调用成功" + port);
        product.setId(new Random().nextInt(20));
        return Result.success("商品添加成功：当前商品服务Ip 端口为"+ ip + ":" + port,product);
    }
    @PutMapping
    public Result editProduct(@RequestBody Product product) {
        log.info("修改商品接口调用成功" + port);
        return Result.success("商品修改成功：当前商品服务Ip 端口为"+ ip + ":" + port,product);
    }
    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable("id") Integer id) {
        return Result.success("商品删除成功：当前商品服务Ip 端口为" + ip + ":" + port, "当前删除商品ID为："+id);
    }
    @GetMapping("/findProductByName")
    public Result findProductByName(@RequestHeader(name = "Authorization",required = false)String token,String name) {
        return Result.success("商品查询成功：当前商品服务Ip 端口为" + ip + ":" + port, "当前查询商品名为："+name+"当前请求头token="+token);
    }
}

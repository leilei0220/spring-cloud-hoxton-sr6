package com.leilei.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/30 18:28
 * @desc
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * openfeign客户端对象 调用商品服务
     */
    private final ProductFeign productFeign;
    @Autowired
    public OrderController(ProductFeign productFeign) {
        this.productFeign = productFeign;
    }
    @GetMapping("/demo")
    public Result findProduct() {
        return Result.success("test---你成功调用到了order服务.");
    }
    @GetMapping("/find/product/{id}")
    public Result findProduct(@PathVariable("id") Integer id) {
        return productFeign.findProduct(id);
    }
    @GetMapping("/find/product")
    public Result findProductByParam(Integer id,String name) {
        return productFeign.findProductByParam(id,name);
    }

    @PostMapping("/place/order")
    public Result  placeOrder() {
        Product product = new Product();
        product.setName("乒乓球");
        product.setPrice(new BigDecimal("25.72"));
        return productFeign.addProduct(product);
    }
    @PutMapping("/place/order")
    public Result  editProduct(@RequestBody Product product) {
        return productFeign.editProduct(product);
    }
    @DeleteMapping("/{id}")
    public Result  editProduct(@PathVariable("id") Integer id) {
        return productFeign.deleteProduct(id);
    }

    @GetMapping("/findProductByName")
    public Result findProductByName(String name) {
        return productFeign.findProductByName(name);
    }
}

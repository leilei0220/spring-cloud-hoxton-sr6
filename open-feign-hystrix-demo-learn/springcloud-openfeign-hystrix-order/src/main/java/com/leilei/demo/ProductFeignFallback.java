package com.leilei.demo;

import org.springframework.stereotype.Service;

/**
 * @author lei
 * @version 1.0
 * @date 2020/9/5 16:13
 * @desc
 */
@Service
public class ProductFeignFallback implements ProductFeign {
    @Override
    public Result findProduct(Integer id) {
        return Result.failure("查询失败，product服务消失啦：商品Id为："+id);
    }

    @Override
    public Result findProductByParam(Integer id, String name) {
        return Result.failure();
    }

    @Override
    public Result addProduct(Product product) { return Result.failure();
    }
    @Override
    public Result editProduct(Product product) { return Result.failure(); }
    @Override
    public Result deleteProduct(Integer id) { return Result.failure(); }

    @Override
    public Result findProductByName(String name) { return Result.failure(); }
}

package com.leilei.demo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/30 21:00
 * @desc
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
}

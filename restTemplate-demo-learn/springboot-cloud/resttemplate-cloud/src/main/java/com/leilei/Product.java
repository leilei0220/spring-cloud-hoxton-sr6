package com.leilei;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/29 13:45
 * @desc
 */
@Data
public class Product {
    private Integer id;
    private String productName;
    private BigDecimal price;
}

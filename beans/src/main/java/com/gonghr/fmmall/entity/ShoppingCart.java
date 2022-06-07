package com.gonghr.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShoppingCart {
    private Integer cartId;
    private String productId;
    private String skuId;
    private String userId;
    private String cartNum;
    private Date cartTime;
    private Double productPrice;
    private String skuProps;
}

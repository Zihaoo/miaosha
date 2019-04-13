package com.miaoshaproject.service.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: Zihaoo
 * @Date: 2019/4/8
 * 用户下单的交易模型
 */


@Data
public class OrderModel {
    //要用string
    private String id;

    private Integer userId;

    private Integer itemId;

    private BigDecimal itemPrice;

    private Integer amount;

    private BigDecimal orderPrice;

    //若非空，表示以秒杀方式下单
    private Integer promoId;
}

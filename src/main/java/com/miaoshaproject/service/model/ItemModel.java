package com.miaoshaproject.service.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: Zihaoo
 * @Date: 2019/4/5
 */
@Data
public class ItemModel {

    private Integer id;

    @NotBlank(message = "商品名称不能为空")
    private String title;

    @NotNull(message = "商品价格不能为空")
    @Min(value = 0,message = "商品价格要大于0")
    private BigDecimal price;

    @NotNull(message = "商品库存不能为空")
    private Integer stock;

    @NotBlank(message = "商品描述不能为空")
    private String description;

    private String sales;

    @NotBlank(message = "商品图片不能为空")
    private String imgUrl;

    //使用聚合模型,如果promoModel不为空，则表示其拥有还未结束的秒杀活动
    private PromoModel promoModel;
}

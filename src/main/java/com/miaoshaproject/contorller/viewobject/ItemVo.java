package com.miaoshaproject.contorller.viewobject;

import java.math.BigDecimal;

/**
 * @Auther: Zihaoo
 * @Date: 2019/4/5
 */
public class ItemVo {

    private Integer id;
    private String title;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String sales;
    private String imgUrl;

    //记录商品是否在秒杀活动中，以及对应的status = 0 没有秒杀活动，为1 待抢购，为2 进行中
    private Integer promoStatus;

    //秒杀活动价格
    private BigDecimal promoPrice;
    //秒杀活动ID
    private Integer promoId;

    private String startDate;
    private Boolean hasActivePromo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPromoStatus() {
        return promoStatus;
    }

    public void setPromoStatus(Integer promoStatus) {
        this.promoStatus = promoStatus;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Boolean getHasActivePromo() {
        return hasActivePromo;
    }

    public void setHasActivePromo(Boolean hasActivePromo) {
        this.hasActivePromo = hasActivePromo;
    }
}

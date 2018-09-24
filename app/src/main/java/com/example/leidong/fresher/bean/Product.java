package com.example.leidong.fresher.bean;

import java.io.Serializable;

/**
 * @program: Fresher
 * @description: 商品
 * @author: Lei Dong
 * @create: 2018-09-23 22:04
 **/
public class Product implements Serializable {
    private String id;

    private String categoryId;

    private String merchantId;

    private String name;

    private String imagePath;

    private float price;

    private String detail;

    public Product(String id, String categoryId, String merchantId, String name, String imagePath, float price, String detail) {
        this.id = id;
        this.categoryId = categoryId;
        this.merchantId = merchantId;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                '}';
    }
}

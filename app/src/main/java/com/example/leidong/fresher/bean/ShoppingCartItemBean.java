package com.example.leidong.fresher.bean;

import java.io.Serializable;

/**
 * Created by Lei Dong on 2018/11/10.
 */
public class ShoppingCartItemBean implements Serializable {
    private String id;

    private String categoryId;

    private String merchantId;

    private String name;

    private String imagePath;

    private float price;

    private int number;

    private String detail;

    public ShoppingCartItemBean(String id, String categoryId, String merchantId, String name, String imagePath, float price, int number, String detail) {
        this.id = id;
        this.categoryId = categoryId;
        this.merchantId = merchantId;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.number = number;
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

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ShoppingCartItemBean{" +
                "id='" + id + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                '}';
    }
}

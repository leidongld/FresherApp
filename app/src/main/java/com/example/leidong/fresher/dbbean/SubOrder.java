package com.example.leidong.fresher.dbbean;

import java.io.Serializable;

/**
 * @program: Fresher
 * @description:
 * @author: Lei Dong
 * @create: 2018-09-23 22:41
 **/
public class SubOrder implements Serializable {
    private String id;

    private String productId;

    private int num;

    public SubOrder(String id, String productId, int num) {
        this.id = id;
        this.productId = productId;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SubOrder{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", num=" + num +
                '}';
    }
}

package com.example.leidong.fresher.dbbean;

/**
 * @program: Fresher
 * @description: 订单
 * @author: Lei Dong
 * @create: 2018-09-23 22:19
 **/
public class Order {
    private String id;

    private String time;

    private String customerId;

    private String merchantId;

    private int totalNums;

    private float totalPrice;

    private String status;

    private String subOrderList;

    public Order(String time, String customerId, String merchantId, int totalNums, float totalPrice, String status, String subOrderList) {
        this.time = time;
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.totalNums = totalNums;
        this.totalPrice = totalPrice;
        this.status = status;
        this.subOrderList = subOrderList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getTotalNums() {
        return totalNums;
    }

    public void setTotalNums(int totalNums) {
        this.totalNums = totalNums;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubOrderList() {
        return subOrderList;
    }

    public void setSubOrderList(String subOrderList) {
        this.subOrderList = subOrderList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", customerId='" + customerId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", totalNums=" + totalNums +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", subOrderList=" + subOrderList +
                '}';
    }
}

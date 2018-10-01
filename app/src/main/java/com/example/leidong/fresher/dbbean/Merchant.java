package com.example.leidong.fresher.dbbean;

import java.io.Serializable;

/**
 * @program: Fresher
 * @description: 商户
 * @author: Lei Dong
 * @create: 2018-09-23 22:10
 **/

public class Merchant implements Serializable {
    private String id;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String mobile;

    private String email;

    private String address;

    private String detail;

    public Merchant(String username, String password, String name, String phone, String mobile, String email, String address, String detail) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.detail = detail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}

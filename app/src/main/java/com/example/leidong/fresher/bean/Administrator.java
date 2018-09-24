package com.example.leidong.fresher.bean;

import java.io.Serializable;

/**
 * @program: Fresher
 * @description: 管理员
 * @author: Lei Dong
 * @create: 2018-09-23 22:42
 **/
public class Administrator implements Serializable {
    private String id;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String mobile;

    private String email;

    public Administrator(String username, String password, String name, String phone, String mobile, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Administrator{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

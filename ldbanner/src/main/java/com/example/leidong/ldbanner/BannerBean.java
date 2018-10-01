package com.example.leidong.ldbanner;

/**
 * Created by Lei Dong on 2018/9/28.
 */
public class BannerBean {
    private String desc;

    private String imageUrl;

    public BannerBean(String desc, String imageUrl) {
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

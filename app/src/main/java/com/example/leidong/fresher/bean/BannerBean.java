package com.example.leidong.fresher.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei Dong on 2018/10/1.
 */
public class BannerBean implements Serializable {
    private String id;

    private String title;

    private String author;

    private String imagePath;

    private String detail;

    public BannerBean(String id, String title, String author, String imagePath, String detail) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取Banner图片地址
     *
     * @param mBannerList
     * @return
     */
    public static List<String> getBannerImagesList(List<BannerBean> mBannerList) {
        List<String> bannerImageList = new ArrayList<>();
        if (mBannerList.size() > 0) {
            for (BannerBean banner : mBannerList) {
                bannerImageList.add(banner.getImagePath());
            }
        }
        return bannerImageList;
    }

    /**
     * 获取Banner的主题地址
     *
     * @param mBannerList
     * @return
     */
    public static List<String> getBannerTitlesList(List<BannerBean> mBannerList) {
        List<String> bannerTitleList = new ArrayList<>();
        if (mBannerList.size() > 0) {
            for (BannerBean banner : mBannerList) {
                bannerTitleList.add(banner.getTitle());
            }
        }
        return bannerTitleList;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}

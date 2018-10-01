package com.example.leidong.fresher.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lei Dong on 2018/10/1.
 */
public class BannerBean implements Serializable {
    private String title;

    private String imagePath;

    public BannerBean(String title, String imagePath) {
        this.title = title;
        this.imagePath = imagePath;
    }

    private String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

}

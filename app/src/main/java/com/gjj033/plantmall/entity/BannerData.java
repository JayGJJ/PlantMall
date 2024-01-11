package com.gjj033.plantmall.entity;

public class BannerData {
    private int bannerImg;
    private String title;

    public BannerData(int bannerImg, String title) {
        this.bannerImg = bannerImg;
        this.title = title;
    }

    public int getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(int bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

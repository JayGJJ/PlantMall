package com.gjj033.plantmall.entity;

public class OrderInfo {
    private int order_id;
    private String username;
    private String plantName;
    private String plantNotice;
    private int plantPrice;
    private int plantImg;
    private int plantCount;
    private String address;
    private String mobile;


    public OrderInfo(int order_id, String username, String plantName, String plantNotice, int plantPrice, int plantImg, int plantCount, String address, String mobile) {
        this.order_id = order_id;
        this.username = username;
        this.plantName = plantName;
        this.plantNotice = plantNotice;
        this.plantPrice = plantPrice;
        this.plantImg = plantImg;
        this.plantCount = plantCount;
        this.address = address;
        this.mobile = mobile;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantNotice() {
        return plantNotice;
    }

    public void setPlantNotice(String plantNotice) {
        this.plantNotice = plantNotice;
    }

    public int getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(int plantPrice) {
        this.plantPrice = plantPrice;
    }

    public int getPlantImg() {
        return plantImg;
    }

    public void setPlantImg(int plantImg) {
        this.plantImg = plantImg;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public void setPlantCount(int plantCount) {
        this.plantCount = plantCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

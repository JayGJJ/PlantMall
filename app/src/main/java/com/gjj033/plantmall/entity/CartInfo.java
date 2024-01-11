package com.gjj033.plantmall.entity;

public class CartInfo {
    private int cartId;
    private String username;
    private int plantId;
    private String plantName;
    private String plantNotice;
    private int plantPrice;
    private int plantImg;
    private int plantCount;

    public CartInfo(int cartId, String username, int plantId, String plantName, String plantNotice, int plantPrice, int plantImg, int plantCount) {
        this.cartId = cartId;
        this.username = username;
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantNotice = plantNotice;
        this.plantPrice = plantPrice;
        this.plantImg = plantImg;
        this.plantCount = plantCount;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public void setPlantCount(int plantCount) {
        this.plantCount = plantCount;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
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
}

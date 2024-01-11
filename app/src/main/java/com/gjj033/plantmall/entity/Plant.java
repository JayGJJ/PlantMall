package com.gjj033.plantmall.entity;

public class Plant {
    private int plantId;
    private String plantName;
    private String plantNotice;
    private int plantPrice;
    private int plantImg;
    private String temperature;
    private String illumination;
    private String season;
    private String color;

    public Plant(int plantId, String plantName, String plantNotice, int plantPrice, int plantImg, String temperature, String illumination, String season, String color) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantNotice = plantNotice;
        this.plantPrice = plantPrice;
        this.plantImg = plantImg;
        this.temperature = temperature;
        this.illumination = illumination;
        this.season = season;
        this.color = color;
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIllumination() {
        return illumination;
    }

    public void setIllumination(String illumination) {
        this.illumination = illumination;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

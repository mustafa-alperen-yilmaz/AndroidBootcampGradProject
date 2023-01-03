package com.example.gradproject.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FoodItem implements Serializable {
    @SerializedName("yemek_id")
    private int foodId;
    @SerializedName("yemek_adi")
    private String foodName;
    @SerializedName("yemek_resim_adi")
    private String foodPicture;
    @SerializedName("yemek_fiyat")
    private int foodPrice;

    public FoodItem() {
    }

    public FoodItem(int foodId, String foodName, String foodImage, int price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPicture = foodImage;
        this.foodPrice = price;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(String foodPicture) {
        this.foodPicture = foodPicture;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
}

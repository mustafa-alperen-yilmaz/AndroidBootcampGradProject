package com.example.gradproject.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodResponse {
    @SerializedName("yemekler")
    private List<FoodItem> foodItemList;
    @SerializedName("success")
    private int success;

    public FoodResponse() {
    }

    public FoodResponse(List<FoodItem> foodItemList, int success) {
        this.foodItemList = foodItemList;
        this.success = success;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}

package com.example.cateringapp.models;

public class FoodCartModel {

    private String foodItemName, foodItemAmount, foodItemCount;

    public FoodCartModel() {
    }

    public FoodCartModel(String foodItemName, String foodItemAmount) {
        this.foodItemName = foodItemName;
        this.foodItemAmount = foodItemAmount;
    }

    public FoodCartModel(String foodItemName, String foodItemAmount, String foodItemCount) {
        this.foodItemName = foodItemName;
        this.foodItemAmount = foodItemAmount;
        this.foodItemCount = foodItemCount;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public String getFoodItemAmount() {
        return foodItemAmount;
    }

    public void setFoodItemAmount(String foodItemAmount) {
        this.foodItemAmount = foodItemAmount;
    }

    public String getFoodItemCount() {
        return foodItemCount;
    }

    public void setFoodItemCount(String foodItemCount) {
        this.foodItemCount = foodItemCount;
    }
}

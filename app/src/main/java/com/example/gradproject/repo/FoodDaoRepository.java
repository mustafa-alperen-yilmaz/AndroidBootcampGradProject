package com.example.gradproject.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.gradproject.entity.CRUDAnswer;
import com.example.gradproject.entity.FoodItem;
import com.example.gradproject.entity.FoodResponse;
import com.example.gradproject.retrofit.FoodDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodDaoRepository {
    private MutableLiveData<List<FoodItem>> foodList;
    private FoodDao foodDao;

    public FoodDaoRepository(FoodDao foodDao) {
        this.foodDao = foodDao;
        foodList = new MutableLiveData();
    }

    public MutableLiveData<List<FoodItem>>getFoodList(){return foodList;}
    public void foodGet(){
        foodDao.downloadFoods().enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                List<FoodItem> list = response.body().getFoodItemList();
                foodList.setValue(list);
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {

            }
        });
    }
    public void addToFoodInToCart(String foodName , String foodImage , int foodPrice, int foodCount , String userName){
        foodDao.addToFoodInToCart(foodName,foodImage,foodPrice,foodCount,userName).enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {

            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {

            }
        });
    }
    public void getToFoodInCart(String userName){
        foodDao.getToFoodInCart(userName).enqueue(new Callback<CRUDAnswer>() {
            @Override
            public void onResponse(Call<CRUDAnswer> call, Response<CRUDAnswer> response) {

            }

            @Override
            public void onFailure(Call<CRUDAnswer> call, Throwable t) {

            }
        });
    }
    public void deleteToFoodInCart(int foodId , String userName){
        foodDao.deleteToFoodInCart(foodId,userName).enqueue(new Callback<CRUDAnswer>() {
            @Override
            public void onResponse(Call<CRUDAnswer> call, Response<CRUDAnswer> response) {
                foodGet();
            }

            @Override
            public void onFailure(Call<CRUDAnswer> call, Throwable t) {

            }
        });
    }
}

package com.example.gradproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gradproject.entity.FoodItem;
import com.example.gradproject.repo.FoodDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainPageViewModel extends ViewModel {
    private FoodDaoRepository foods;
    public MutableLiveData<List<FoodItem>> foodItemList = new MutableLiveData<>();
    @Inject
    public MainPageViewModel(FoodDaoRepository foods){
        this.foods = foods;
        foodGet();
        foodItemList = foods.getFoodList();
    }
    public void foodGet(){
        foods.foodGet();
    }
}

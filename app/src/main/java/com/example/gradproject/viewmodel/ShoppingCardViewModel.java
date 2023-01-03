package com.example.gradproject.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.gradproject.repo.FoodDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ShoppingCardViewModel extends ViewModel {
    private FoodDaoRepository repository;

    @Inject
    public ShoppingCardViewModel(FoodDaoRepository repository){
        this.repository = repository;
    }

}

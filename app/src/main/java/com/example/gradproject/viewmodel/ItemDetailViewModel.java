package com.example.gradproject.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.gradproject.repo.FoodDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ItemDetailViewModel extends ViewModel {
    private FoodDaoRepository repository;

    @Inject
    public ItemDetailViewModel(FoodDaoRepository repository){
        this.repository = repository;
    }

}

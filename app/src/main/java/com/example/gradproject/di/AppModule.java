package com.example.gradproject.di;

import com.example.gradproject.repo.FoodDaoRepository;
import com.example.gradproject.retrofit.ApiUtils;
import com.example.gradproject.retrofit.FoodDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public FoodDaoRepository provideFoodDaoRepository(FoodDao foodDao){return new FoodDaoRepository(foodDao);}
    @Provides
    @Singleton
    public FoodDao provideFoodDao(){
        return ApiUtils.getFoodDao();
    }
}

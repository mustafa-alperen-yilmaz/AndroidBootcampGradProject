package com.example.gradproject.retrofit;

import com.example.gradproject.entity.CRUDAnswer;
import com.example.gradproject.entity.FoodResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FoodDao {
    @GET("yemekler/tumYemekleriGetir.php")
    Call<FoodResponse> downloadFoods();

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<FoodResponse> addToFoodInToCart(
            @Field("yemek_adi") String foodName ,
            @Field("yemek_resim_adi") String foodImage ,
            @Field("yemek_fiyat")int foodPrice,
            @Field("yemek_siparis_adet")int foodCount ,
            @Field("kullanici_adi")String userName
    );
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<CRUDAnswer> getToFoodInCart(@Field("kullanici_adi")String userName);

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    Call<CRUDAnswer> deleteToFoodInCart(@Field("sepet_yemek_id")int foodId ,
                                        @Field("kullanici_adi")String userName);
}

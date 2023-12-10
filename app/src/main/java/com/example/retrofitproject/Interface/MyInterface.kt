package com.example.retrofitproject.Interface

import com.example.retrofitproject.RetrofitResponseItem
import retrofit2.http.GET

interface MyInterface {

    @GET("photos")
    suspend fun getProduct() : List<RetrofitResponseItem>
}
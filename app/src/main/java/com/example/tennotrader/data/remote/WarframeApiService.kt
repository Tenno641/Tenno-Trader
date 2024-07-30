package com.example.tennotrader.data.remote

import com.example.tennotrader.data.model.Items
import retrofit2.Call
import retrofit2.http.GET

interface WarframeApiService {

    @GET("items")
    fun getItems(): Call<Items>

}
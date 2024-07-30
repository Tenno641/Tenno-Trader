package com.example.tennotrader.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WarframeRepository {

    private val baseUrl: String = "https://api.warframe.market/v1/"

    fun getRetrofitService(): WarframeApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(WarframeApiService::class.java)

    }

}
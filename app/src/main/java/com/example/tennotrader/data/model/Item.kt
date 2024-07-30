package com.example.tennotrader.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    val id: String,
    @SerializedName("item_name") val itemName: String,
    val thumb: String,
    @SerializedName("url_name") val urlName: String
)
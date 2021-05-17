package com.example.hofftest2.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("items") val orders: List<Order>,
)
package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class Services(
    @SerializedName("icon") val icon: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Int,
)
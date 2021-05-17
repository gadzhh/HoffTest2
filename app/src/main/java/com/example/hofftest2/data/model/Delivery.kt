package com.example.hofftest2.data.model

import com.google.gson.annotations.SerializedName

data class Delivery(
    @SerializedName("name") val name: Int,
    @SerializedName("icon") val icon: String
)
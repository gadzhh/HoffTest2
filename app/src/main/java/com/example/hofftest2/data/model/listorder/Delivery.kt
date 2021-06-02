package com.example.hofftest2.data.model.listorder

import com.google.gson.annotations.SerializedName

data class Delivery(
    @SerializedName("name") val name: String,
    @SerializedName("icon") val icon: String
)
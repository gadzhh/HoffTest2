package com.example.hofftest2.data.model.listorder

import com.google.gson.annotations.SerializedName

data class OrderStatus(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)
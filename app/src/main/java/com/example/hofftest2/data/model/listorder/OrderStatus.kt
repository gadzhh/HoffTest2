package com.example.hofftest2.data.model.listorder

import com.google.gson.annotations.SerializedName

data class OrderStatus(
    @SerializedName("id") val orderStatusId: Int,
    @SerializedName("name") val name: String
)
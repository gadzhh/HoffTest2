package com.example.hofftest2.data.model.listorder

import com.google.gson.annotations.SerializedName

data class OrderItems(
    @SerializedName("id") val id: String,
    @SerializedName("number") val number: String,
    @SerializedName("datetime") val dateTime: Int,
    @SerializedName("status") val orderStatus: OrderStatus,
    @SerializedName("delivery") val delivery: Delivery,
    @SerializedName("phone") val phone: String,
    @SerializedName("sum") val sum: Int
)
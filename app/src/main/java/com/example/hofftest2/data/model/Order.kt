package com.example.hofftest2.data.model

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("id") val id: Int,
    @SerializedName("number") val number: Int,
    @SerializedName("datetime") val dateTime: Int,
    @SerializedName("sum") val sum: Int,
    @SerializedName("status") val status: Status,
    @SerializedName("delivery") val delivery: Delivery
)
package com.example.hofftest2.data.model.listorder

import com.google.gson.annotations.SerializedName

data class OrderList(
    @SerializedName("items") val orderItems: List<OrderItems>
)

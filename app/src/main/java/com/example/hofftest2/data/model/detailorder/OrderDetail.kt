package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class OrderDetail(
    @SerializedName("address") val address: String,
    @SerializedName("payment") val payment: Payment,
    @SerializedName("bonusCard") val bonusCard: Long,
    @SerializedName("totalItemCount") val totalItemCount: Int,
    @SerializedName("items") val detailItems: List<DetailItems>,
    @SerializedName("services") val services: List<Services>,
    @SerializedName("amount") val amount: Amount,
    @SerializedName("status") val status: Status,
    @SerializedName("deliveryTime") val deliveryTime: DeliveryTime
)
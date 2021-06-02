package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class DeliveryTime(
    @SerializedName("canSet") val canSet: Boolean,
    @SerializedName("type") val type: String,
    @SerializedName("serviceId") val serviceId: String,
    @SerializedName("data") val dateAndTime: DateAndTime
)
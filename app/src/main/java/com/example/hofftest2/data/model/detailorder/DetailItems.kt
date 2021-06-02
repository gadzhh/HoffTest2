package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class DetailItems(
    @SerializedName("articul") val articul: String,
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("imageUrl") val image: String
)
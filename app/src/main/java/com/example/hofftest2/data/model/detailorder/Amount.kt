package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class Amount(
    @SerializedName("bonuses") val bonuses: Int,
    @SerializedName("discount") val discount: Int,
    @SerializedName("total") val total: Int
)
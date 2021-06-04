package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class DetailStatus(
    @SerializedName("id") val detailId: Int,
    @SerializedName("name") val name: String
)
package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class DetailStatus(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)
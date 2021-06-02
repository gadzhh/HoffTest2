package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

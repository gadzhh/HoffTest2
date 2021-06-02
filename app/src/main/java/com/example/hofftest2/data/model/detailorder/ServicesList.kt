package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class ServicesList(
    @SerializedName("services") val servicesList: List<Services>
)

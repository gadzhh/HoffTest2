package com.example.hofftest2.data.model.detailorder

import com.google.gson.annotations.SerializedName

data class DateAndTime(
    @SerializedName("date") val date: String,
    @SerializedName("time") val time: String
)
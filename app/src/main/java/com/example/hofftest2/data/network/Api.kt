package com.example.hofftest2.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("order_list_ax")
    fun getListOrder(
        @Query("device_id") deviceId: String,
        @Query("isAndroid") isAndroid: Boolean,
        @Query("isGooglePayEnabled") isGooglePayEnabled: Int,
        @Query("isSamsungPayEnabled") isSamsungPayEnabled: Int,
        @Query("isAvailableSberPay") isAvailableSberPay: Int,
        @Query("app_version") appVersion: String,
        @Query("token") token: String,
        @Query("location") location: String
    )

    @GET("order_info_ax")
    fun getDetailOrder(
        @Query("order_id") orderId: String,
        @Query("device_id") deviceId: String,
        @Query("isAndroid") isAndroid: Boolean,
        @Query("isGooglePayEnabled") isGooglePayEnabled: Int,
        @Query("isSamsungPayEnabled") isSamsungPayEnabled: Int,
        @Query("isAvailableSberPay") isAvailableSberPay: Int,
        @Query("app_version") appVersion: String,
        @Query("token") token: String,
        @Query("location") location: String
    )
}
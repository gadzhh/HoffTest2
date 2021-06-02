package com.example.hofftest2.data.network

import com.example.hofftest2.data.model.detailorder.OrderDetail
import com.example.hofftest2.data.model.listorder.OrderList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("order_list_ax?")
    fun getListOrder(
        @Query("device_id") deviceId: String,
        @Query("isAndroid") isAndroid: Boolean,
        @Query("isGooglePayEnabled") isGooglePayEnabled: Int,
        @Query("isSamsungPayEnabled") isSamsungPayEnabled: Int,
        @Query("isAvailableSberPay") isAvailableSberPay: Int,
        @Query("app_version") appVersion: String,
        @Query("token") token: String,
        @Query("location") location: Int,
    ): Single<OrderList>

    @GET("order_info_ax?")
    fun getDetailOrder(
        @Query("order_id") orderId: String,
        @Query("device_id") deviceId: String,
        @Query("isAndroid") isAndroid: Boolean,
        @Query("isGooglePayEnabled") isGooglePayEnabled: Int,
        @Query("isSamsungPayEnabled") isSamsungPayEnabled: Int,
        @Query("isAvailableSberPay") isAvailableSberPay: Int,
        @Query("app_version") appVersion: String,
        @Query("token") token: String,
        @Query("location") location: Int,
    ): Single<OrderDetail>
}
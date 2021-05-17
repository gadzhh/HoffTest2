package com.example.hofftest2

import android.app.Application
import com.example.hofftest2.data.global.DataManager
import com.example.hofftest2.data.network.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://hoff.ru/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
        dataManager = DataManager()
    }

    companion object {
        private lateinit var api: Api
        fun jSONApi(): Api = api

        private lateinit var dataManager: DataManager
        fun getDataManager() = dataManager
    }
}
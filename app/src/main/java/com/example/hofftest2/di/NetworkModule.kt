package com.example.hofftest2.di

import com.example.hofftest2.data.network.Api
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun retrofitService(): Api =
        Retrofit.Builder()
            .baseUrl("https://hoff.ru/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(Api::class.java)

//    @Singleton
//    @Provides
//    fun api(retrofit: Retrofit): Api {
//        return retrofit.create(Api::class.java)
//    }
}

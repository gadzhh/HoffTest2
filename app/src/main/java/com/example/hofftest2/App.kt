package com.example.hofftest2

import com.example.hofftest2.di.AppComponent
import android.app.Application
import com.example.hofftest2.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initDagger()
    }

    private fun initDagger(){
        appComponent = DaggerAppComponent.builder().context(applicationContext).build()
    }
    companion object {
        lateinit var appComponent: AppComponent
    }
}
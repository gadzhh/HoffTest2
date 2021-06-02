package com.example.hofftest2.di

import com.example.hofftest2.data.SchedulersProviderImpl
import com.example.hofftest2.domain.common.SchedulersProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class SchedulersModule {
    @Binds
    @Singleton
    abstract fun schedulersProvider(schedulersProviderImpl: SchedulersProviderImpl): SchedulersProvider
}
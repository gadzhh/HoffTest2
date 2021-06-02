package com.example.hofftest2.di

import com.example.hofftest2.data.repositoryImpl.OrderRepositoryImpl
import com.example.hofftest2.domain.repository.OrderRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class OrdersModule {
    @Binds
    @Singleton
    abstract fun listRepository(repositoryImpl: OrderRepositoryImpl): OrderRepository
}
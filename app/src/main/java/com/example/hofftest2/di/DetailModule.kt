package com.example.hofftest2.di

import com.example.hofftest2.data.network.Api
import com.example.hofftest2.data.repositoryImpl.DetailRepositoryImpl
import com.example.hofftest2.domain.repository.DetailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DetailModule {
    @Binds
    @Singleton
    abstract fun detailRepository(detailRepositoryImpl: DetailRepositoryImpl): DetailRepository
}
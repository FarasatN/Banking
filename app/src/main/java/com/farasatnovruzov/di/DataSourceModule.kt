package com.farasatnovruzov.di

import com.farasatnovruzov.banking.data.network.BankApiService
import com.farasatnovruzov.repository.datasource.RemoteDataSource
import com.farasatnovruzov.repository.datasourceimpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(bankApiService: BankApiService): RemoteDataSource {
        return RemoteDataSourceImpl(bankApiService)
    }

}
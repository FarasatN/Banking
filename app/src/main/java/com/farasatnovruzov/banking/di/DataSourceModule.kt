package com.farasatnovruzov.banking.di

import com.farasatnovruzov.banking.data.network.BankApiService
import com.farasatnovruzov.banking.repository.datasource.RemoteDataSource
import com.farasatnovruzov.banking.repository.datasourceimpl.RemoteDataSourceImpl
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
package com.farasatnovruzov.banking.di

import com.farasatnovruzov.banking.domain.repository.BankRepository
import com.farasatnovruzov.banking.domain.repository.BankRepositoryImpl
import com.farasatnovruzov.banking.repository.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBankRepository(remoteDataSource: RemoteDataSource): BankRepository {
        return BankRepositoryImpl(remoteDataSource)
    }
}
package com.farasatnovruzov.di

import com.farasatnovruzov.domain.repository.BankRepository
import com.farasatnovruzov.domain.repository.BankRepositoryImpl
import com.farasatnovruzov.repository.datasource.RemoteDataSource
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
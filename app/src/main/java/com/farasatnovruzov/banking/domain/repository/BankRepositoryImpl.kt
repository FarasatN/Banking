package com.farasatnovruzov.banking.domain.repository

import com.farasatnovruzov.banking.data.BankData
import com.farasatnovruzov.banking.common.Resource
import com.farasatnovruzov.banking.repository.datasource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BankRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BankRepository {
    override fun getBankDataRepository(): Flow<Resource<BankData>> = flow {
        emit(Resource.Loading())
        val result = runCatching {
            remoteDataSource.getBankDataSource()
        }.onFailure {
            emit(Resource.Error(it.message.toString()))
        }.getOrNull()

        result?.let {
            emit(Resource.Success(it))
        }


    }

}
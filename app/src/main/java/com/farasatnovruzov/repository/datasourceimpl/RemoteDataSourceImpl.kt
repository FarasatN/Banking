package com.farasatnovruzov.repository.datasourceimpl

import com.farasatnovruzov.banking.data.BankData
import com.farasatnovruzov.banking.data.network.BankApiService
import com.farasatnovruzov.repository.datasource.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val bankApiService: BankApiService
): RemoteDataSource {
    override suspend fun getBankDataSource(): BankData {
        return bankApiService.getBankDataNetwork()
    }

}
package com.farasatnovruzov.repository.datasource

import com.farasatnovruzov.banking.data.BankData

interface RemoteDataSource {

    suspend fun getBankDataSource(): BankData
}
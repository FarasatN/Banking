package com.farasatnovruzov.banking.repository.datasource

import com.farasatnovruzov.banking.data.BankData

interface RemoteDataSource {

    suspend fun getBankDataSource(): BankData
}
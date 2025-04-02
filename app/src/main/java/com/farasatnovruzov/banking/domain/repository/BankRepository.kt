package com.farasatnovruzov.banking.domain.repository

import com.farasatnovruzov.banking.data.BankData
import com.farasatnovruzov.banking.common.Resource
import kotlinx.coroutines.flow.Flow

interface BankRepository {

    fun getBankDataRepository(): Flow<Resource<BankData>>
}
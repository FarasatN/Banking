package com.farasatnovruzov.banking.data.network

import com.farasatnovruzov.banking.data.BankData
import retrofit2.http.GET

interface BankApiService {

    @GET("/bankdata")
    suspend fun getBankDataNetwork(): BankData

}
package com.farasatnovruzov.banking.domain.usecase

import com.farasatnovruzov.banking.domain.repository.BankRepository
import javax.inject.Inject

class GetBankDataUseCase @Inject constructor(
    private val bankRepository: BankRepository
){

    fun invoke() = bankRepository.getBankDataRepository()

}
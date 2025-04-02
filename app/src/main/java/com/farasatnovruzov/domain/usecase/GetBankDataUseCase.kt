package com.farasatnovruzov.domain.usecase

import com.farasatnovruzov.domain.repository.BankRepository
import javax.inject.Inject

class GetBankDataUseCase @Inject constructor(
    private val bankRepository: BankRepository
){

    fun invoke() = bankRepository.getBankDataRepository()

}
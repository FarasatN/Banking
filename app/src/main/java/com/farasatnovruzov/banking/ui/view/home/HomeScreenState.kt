package com.farasatnovruzov.banking.ui.view.home

import com.farasatnovruzov.banking.common.Resource
import com.farasatnovruzov.banking.data.BankData
import com.farasatnovruzov.banking.data.BankDataItem

data class HomeScreenState(
    val isLoading: Boolean = false,
    val bankData: List<BankDataItem>? = null,
    val errorMessage: String? = null
)
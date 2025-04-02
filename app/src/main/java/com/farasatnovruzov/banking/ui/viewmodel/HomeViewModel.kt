package com.farasatnovruzov.banking.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farasatnovruzov.banking.common.Resource
import com.farasatnovruzov.banking.data.BankDataItem
import com.farasatnovruzov.banking.domain.usecase.GetBankDataUseCase
import com.farasatnovruzov.banking.ui.view.home.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBankDataUseCase: GetBankDataUseCase
) : ViewModel() {

    private val _homeState = mutableStateOf(HomeScreenState())
    val homeState: State<HomeScreenState> = _homeState

    //    private val _filteredBankList = mutableStateOf<List<BankDataItem>>(emptyList<BankDataItem>())
    private val _filteredBankList = mutableStateOf(emptyList<BankDataItem>())
    val filteredBankList: State<List<BankDataItem>> = _filteredBankList

    init {
        getBankList()
    }

    private fun getBankList() = viewModelScope.launch {
        getBankDataUseCase.invoke().collect {
            when (it) {
                is Resource.Error -> {
                    _homeState.value = HomeScreenState(isLoading = false)
                    _homeState.value = HomeScreenState(errorMessage = it.message.toString())
                }

                is Resource.Loading -> {
                    _homeState.value = HomeScreenState(isLoading = true)
                }

                is Resource.Success -> {
                    delay(2000L)
                    _homeState.value = HomeScreenState(isLoading = false)
                    _homeState.value = HomeScreenState(bankData = it.data)
                    _filteredBankList.value = it.data ?: emptyList()
                }
            }
        }
    }

    fun filterBankList(query: String) {
        _filteredBankList.value = _homeState.value.bankData?.filter {
            (it.bankDistrict?.contains(query, ignoreCase = true) == true) || (it.bankCity?.contains(
                query,
                ignoreCase = true
            ) == true)
        } ?: emptyList()
    }

}


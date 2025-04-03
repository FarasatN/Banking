package com.farasatnovruzov.banking.ui.view.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.farasatnovruzov.banking.data.BankDataItem
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun DetailScreen(
    bankDataJson: String,

){
    val viewModel: DetailViewModel = hiltViewModel()
    val context = LocalContext.current
    val gson = Gson()

    // Bank Data
    val bankJson = URLDecoder.decode(bankDataJson, StandardCharsets.UTF_8.toString())
    val bankData = gson.fromJson(bankJson, BankDataItem::class.java)

    // Log Firebase Event
    viewModel.logDetailPageEvent(bankData.bankCity ?: "")

}
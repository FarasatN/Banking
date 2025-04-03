package com.farasatnovruzov.banking.ui.view.home

import android.app.Activity
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.work.Configuration
import coil3.compose.AsyncImage
import com.farasatnovruzov.banking.R
import com.farasatnovruzov.banking.data.BankDataItem
import com.farasatnovruzov.banking.ui.viewmodel.HomeViewModel
import com.google.gson.Gson
import java.util.Locale


@Composable
fun HomeScreen(navController: NavController) {

    val viewModel: HomeViewModel = hiltViewModel()
    val context = LocalContext.current
    val gson = Gson()

    BackHandler {
        (context as? Activity)?.finish()
    }

    val state = viewModel.homeState.value
    val filteredBankData = viewModel.filteredBankList.value
    val searchQuery = remember { mutableStateOf("") }

    val currentNavController = rememberUpdatedState(navController)
    val flagTR = painterResource(R.drawable.ic_launcher_background)
    val flagEN = painterResource(R.drawable.ic_launcher_foreground)

    Scaffold(
        topBar = {
            Column {
                TextField(
                    value = searchQuery.value,
                    onValueChange = {newValue->
                        searchQuery.value = newValue
                        viewModel.filterBankList(searchQuery.value)
                    },
                    label = {
                        Text(text = "Search City/District")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AsyncImage(
                    model = flagTR,
                    contentDescription = "Turkey Flag",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            changeLanguage(context, currentNavController, "tr")
                        },
                    contentScale = ContentScale.Crop
                )
                AsyncImage(
                    model = flagEN,
                    contentDescription = "US Flag",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            changeLanguage(context, currentNavController, "en")
                        },
                    contentScale = ContentScale.Crop

                )
            }

            if (state.isLoading) {
                LoadingState()
            } else {
                if (!state.errorMessage.isNullOrBlank()) {

                    ErrorMessage(state)

                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        if (filteredBankData.isEmpty()) {
                            item {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(modifier = Modifier.fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        if (state.isLoading) Text("No data",color = Color.Red)


                                    }
                                }

                            }
                        }else{
                            items(filteredBankData){bankItem ->
                                 BankItem(bankItem = bankItem){

                                 }
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun BankItem(
    bankItem: BankDataItem = BankDataItem(),
    onclick: () -> Unit = {}

) {
    Card(
        modifier = Modifier.padding(4.dp)
            .clickable { onclick.invoke() }
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            if (bankItem.bankBranch.isNullOrEmpty()) {
                Text(text = "No Branch")
            } else {
                Text(text = bankItem.bankBranch)
            }
        }
    }
}


@Composable
fun LoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Determinate
        CircularProgressIndicator(progress = 0.5f)
    }
}

@Composable
fun ErrorMessage(state: HomeScreenState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = state?.errorMessage!!,
            modifier = Modifier.fillMaxSize(),
            color = Color.Red
        )
    }
}

fun changeLanguage(
    context: Context,
    currentNavController: State<NavController>,
    language: String
) {
    val local = Locale(language)
    Locale.setDefault(local)
    val config = android.content.res.Configuration()
    config.setLocale(local)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
    val currentDestination = currentNavController.value.currentDestination?.id
    currentNavController.value.popBackStack()
    currentDestination?.let {
        currentNavController.value.navigate(it)
    }
}





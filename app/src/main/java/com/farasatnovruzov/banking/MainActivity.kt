package com.farasatnovruzov.banking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.farasatnovruzov.banking.ui.theme.BankingTheme
import com.farasatnovruzov.banking.ui.view.home.HomeScreen
import com.farasatnovruzov.banking.ui.view.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    SplashScreen()
//                        HomeScreen(navController = "home")
                }
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BankingTheme {
//        SplashScreen()
//    }
//}
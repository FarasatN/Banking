package com.farasatnovruzov.banking.ui.navigation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.farasatnovruzov.banking.ui.view.detail.DetailScreen
import com.farasatnovruzov.banking.ui.view.home.HomeScreen
import com.farasatnovruzov.banking.ui.view.splash.SplashScreen


@Composable
fun AppNavigation(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = AppScreen.SPLASH_SCREEN.name,
        modifier = Modifier
    ) {
        composable(AppScreen.SPLASH_SCREEN.name) {
            SplashScreen(navHostController)
        }
        composable(AppScreen.HOME_SCREEN.name, enterTransition = {
            slideInHorizontally(
                initialOffsetX = { -1000 }, animationSpec = tween(
                    durationMillis = 500, easing = LinearOutSlowInEasing
                )
            )
        }
        ,
            exitTransition = {
                slideOutHorizontally (
                    targetOffsetX = { -1000},
                    animationSpec = tween(
                        durationMillis = 500, easing = LinearOutSlowInEasing
                    )
                )
            } ){
            HomeScreen(navHostController)

        }
        composable("AppScreen.DETAIL_SCREEN.name"+"/{bankDataJson}",
            arguments = listOf(navArgument("bankDataJson") { type = NavType.StringType }),
            ) { backStackEntry ->
            val bankDataJson = backStackEntry.arguments?.getString("bankDataJson")
            DetailScreen(bankDataJson!!)
        }

    }
}
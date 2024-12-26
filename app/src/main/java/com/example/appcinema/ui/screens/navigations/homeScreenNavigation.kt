package com.example.appcinema.ui.screens.navigations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.appcinema.ui.screens.homeScreen.HomeScreen


internal const val homeScreenRoute = "HomeScreen"

fun NavGraphBuilder.homeScreenNavigation(navController: NavHostController) {

    composable(homeScreenRoute) {
        HomeScreen(navController)
    }

    fun NavController.navToHomeScreen(navOptions: NavOptions? = null) {
        navigate(homeScreenRoute, navOptions)
    }
}
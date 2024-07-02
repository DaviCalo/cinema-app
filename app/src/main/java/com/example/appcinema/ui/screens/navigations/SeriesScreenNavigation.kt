package com.example.appcinema.ui.screens.navigations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.appcinema.ui.screens.allSeriesScreen.AllSeriesScreen

internal const val seriesScreenRoute = "SeriesScreen"

fun NavGraphBuilder.seriesScreenNavigation(navController: NavHostController) {
    composable(seriesScreenRoute) {
        AllSeriesScreen(navController)
    }


    fun NavController.navToSeriesScreen(navOptions: NavOptions? = null){
        navigate(seriesScreenRoute, navOptions)
    }
}

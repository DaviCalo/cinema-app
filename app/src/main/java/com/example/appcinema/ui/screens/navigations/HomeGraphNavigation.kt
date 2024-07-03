package com.example.appcinema.ui.screens.navigations


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import movieScreenNavigation
import movieScreenRoute

internal const val homeGraphRoute = "Home"

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(
        startDestination = homeScreenRoute,
        route = homeGraphRoute
    ) {
        movieScreenNavigation(navController)
        seriesScreenNavigation(navController)
        homeScreenNavigation(navController)
    }
}

fun NavController.navigateToHomeGraph() {
    navigate(homeScreenRoute)
}

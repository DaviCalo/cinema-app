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
        startDestination = movieScreenRoute,
        route = homeGraphRoute
    ) {
        movieScreenNavigation(navController)
        seriesScreenNavigation(navController)
    }
}

fun NavController.navigateToHomeGraph() {
    navigate(homeGraphRoute)
}

/*
@OptIn(ExperimentalMaterial3Api::class)
fun NavController.navigateSingleTopWithPopUpTo(
    item: TopAppBarDefaults
) {
    val (route, navigate) = when (item) {
        TopBar(). -> Pair(
            drinksRoute,
            ::navigateToDrinksList
        )

        BottomAppBarItem.HighlightsList -> Pair(
            highlightsListRoute,
            ::navigateToHighlightsList
        )

        BottomAppBarItem.Menu -> Pair(
            menuRoute,
            ::navigateToMenuList
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)

    }

    navigate(navOptions)
}*/

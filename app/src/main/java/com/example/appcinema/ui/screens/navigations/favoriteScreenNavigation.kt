package com.example.appcinema.ui.screens.navigations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.appcinema.ui.screens.favoriteScreen.FavoriteScreen
import movieScreenRoute

internal const val favoriteScreenRoute = "FavoriteScreen"

fun NavGraphBuilder.favoriteScreenNavigation(navController: NavHostController) {

    composable(favoriteScreenRoute) {
        FavoriteScreen(navController)
    }

    fun NavController.navToFavoriteScreen(navOptions: NavOptions? = null){
        navigate(favoriteScreenRoute, navOptions)
    }
}
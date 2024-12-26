package com.example.appcinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.appcinema.ui.screens.navigations.favoriteScreenNavigation
import com.example.appcinema.ui.screens.navigations.favoriteScreenRoute
import com.example.appcinema.ui.screens.navigations.homeScreenNavigation
import com.example.appcinema.ui.screens.navigations.homeScreenRoute
import com.example.appcinema.ui.screens.navigations.seriesScreenNavigation
import com.example.appcinema.ui.theme.APPCinemaTheme
import detailsMovieScreenNavigation
import detailsSeriesScreenNavigation
import movieScreenNavigation
import movieScreenRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.Black.toArgb())
        )
        setContent {
            APPCinemaTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = homeScreenRoute) {

        seriesScreenNavigation(navController)

        homeScreenNavigation(navController)

        favoriteScreenNavigation(navController)

        movieScreenNavigation(navController)

        detailsSeriesScreenNavigation(navController)

        detailsMovieScreenNavigation(navController)
    }
}
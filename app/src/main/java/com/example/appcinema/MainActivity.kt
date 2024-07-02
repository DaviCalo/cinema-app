package com.example.appcinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appcinema.ui.theme.APPCinemaTheme
import com.example.appcinema.ui.screens.detailsMoviesScreen.DetailsMoviesScreen
import com.example.appcinema.ui.screens.detailsSeriesScreen.DetailsSeriesScreen
import com.example.appcinema.ui.screens.favoriteScreen.AllFavoriteMoviesCards
import com.example.appcinema.ui.screens.favoriteScreen.FavoriteScreen
import com.example.appcinema.ui.screens.navigations.homeGraphRoute
import com.example.appcinema.ui.screens.navigations.seriesScreenNavigation
import com.example.appcinema.ui.screens.navigations.seriesScreenRoute
import detailsMovieScreenNavigation
import detailsSeriesScreenNavigation
import movieScreenNavigation
import movieScreenRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
    NavHost(navController = navController, startDestination = movieScreenRoute) {

        seriesScreenNavigation(navController)

        movieScreenNavigation(navController)

        detailsSeriesScreenNavigation(navController)

        detailsMovieScreenNavigation(navController)
    }
}
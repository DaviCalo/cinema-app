package com.example.appcinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appcinema.ui.screens.allMoviesScreen.AllMoviesScreen
import com.example.appcinema.ui.theme.APPCinemaTheme
import com.example.appcinema.ui.screens.allSeriesScreen.AllSeriesScreen
import com.example.appcinema.ui.screens.detailsMoviesScreen.DetailsMoviesScreen
import com.example.appcinema.ui.screens.detailsSeriesScreen.DetailsSeriesScreen

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
    NavHost(navController = navController, startDestination = "SeriesScreen") {
        composable("SeriesScreen") {
            AllSeriesScreen(navController)
        }
        composable("MoviesScreen") {
           AllMoviesScreen(navController)
        }
        composable(
            route = "DetailsSeriesScreen/{detailsCard}",
            arguments = listOf(navArgument("detailsCard") { type = NavType.IntType })
        ) { backStackEntry ->
            val idCard = backStackEntry.arguments?.getInt("detailsCard")
            DetailsSeriesScreen(navController,  idCard?: 0)
        }
        composable(
            route = "DetailsMoviesScreen/{detailsCard}",
            arguments = listOf(navArgument("detailsCard") { type = NavType.IntType })
        ) { backStackEntry ->
            val idCard = backStackEntry.arguments?.getInt("detailsCard")
            DetailsMoviesScreen(navController,  idCard?: 0)
        }
    }
}

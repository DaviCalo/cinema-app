import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appcinema.ui.screens.detailsMoviesScreen.DetailsMoviesScreen

internal const val detailsMovieScreenRoute = "detailsMoviesScreen"

fun NavGraphBuilder.detailsMovieScreenNavigation(navController: NavHostController) {
    composable(
        route = "$detailsMovieScreenRoute/{detailsCard}",
        arguments = listOf(navArgument("detailsCard") { type = NavType.IntType })
    ) { backStackEntry ->
        val idCard = backStackEntry.arguments?.getInt("detailsCard")
        DetailsMoviesScreen(navController, idCard ?: 0)
    }

    fun NavController.navToDetailsMovieScreen(navOptions: NavOptions? = null){
        navigate(detailsMovieScreenRoute, navOptions)
    }
}


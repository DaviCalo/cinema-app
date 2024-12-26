import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.appcinema.ui.screens.allMoviesScreen.AllMoviesScreen
import com.example.appcinema.ui.screens.allSeriesScreen.AllSeriesScreen
import com.example.appcinema.ui.screens.favoriteScreen.FavoriteScreen

internal const val movieScreenRoute = "MovieScreen"

fun NavGraphBuilder.movieScreenNavigation(navController: NavHostController) {

    composable(movieScreenRoute) {
        AllMoviesScreen(navController)
    }

    fun NavController.navToMovieScreen(navOptions: NavOptions? = null){
        navigate(movieScreenRoute, navOptions)
    }
}






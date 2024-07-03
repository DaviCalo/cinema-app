import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appcinema.ui.screens.detailsSeriesScreen.DetailsSeriesScreen

internal const val  detailsSeriesScreenRoute = "DetailsSeriesScreen"

fun NavGraphBuilder.detailsSeriesScreenNavigation(navController: NavHostController) {
    composable(
        route = "$detailsSeriesScreenRoute/{detailsCard}",
        arguments = listOf(navArgument("detailsCard") { type = NavType.IntType })
    ) { backStackEntry ->
        val idCard = backStackEntry.arguments?.getInt("detailsCard")
        DetailsSeriesScreen(navController, idCard ?: 0)
    }

    fun NavController.navToDetailsSeriesScreen(navOptions: NavOptions? = null){
        navigate(detailsSeriesScreenRoute, navOptions)
    }
}
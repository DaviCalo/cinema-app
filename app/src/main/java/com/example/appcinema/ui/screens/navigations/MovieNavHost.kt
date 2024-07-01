import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.appcinema.ui.screens.navigations.homeGraph
import com.example.appcinema.ui.screens.navigations.homeGraphRoute

@Composable
fun MovieNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = homeGraphRoute,
    ) {
        homeGraph(navController)

        //Navegação entre as telas com Type Safety
        detailsSeriesScreenNavigation(navController)
        detailsMovieScreenNavigation(navController)
    }

}
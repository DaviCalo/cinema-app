package com.example.appcinema.ui.screens.favoriteScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appcinema.model.CardModel
import com.example.appcinema.ui.components.TopBar
import com.example.appcinema.ui.theme.BackgroundColor

@Composable
fun FavoriteScreen(navController: NavHostController) {
    val viewModel = viewModel<FavoriteViewModel>()
    val listAllMovies = viewModel.listAllMovies
    Scaffold(
        topBar = { TopBar() },
        modifier = Modifier.systemBarsPadding().background(Color.DarkGray)
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .background(BackgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Favoritos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
            if (!listAllMovies.isNullOrEmpty()) {
                AllFavoriteMoviesCards(listAllMovies, navController, viewModel)
            }
        }
    }
}

@Composable
fun AllFavoriteMoviesCards(listAll: Array<CardModel>, navHostController: NavHostController, viewModel: FavoriteViewModel){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(135.dp),
        modifier = Modifier.background(BackgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center
    ) {
        items(listAll.size) { item ->
            Card(
                Modifier
                    .padding(7.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { navHostController.navigate("DetailsMoviesScreen/${listAll[item].id}") }
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w500${listAll[item].poster_path}")
                        .crossfade(true)
                        .build(),
                    contentDescription = "CardFilms",
                    contentScale = ContentScale.Fit
                )
            }
        }
        item{
//            NavigationPageButton { viewModel.nextPage() }
        }
    }
}
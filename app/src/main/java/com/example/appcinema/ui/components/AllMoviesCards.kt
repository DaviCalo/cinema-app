package com.example.appcinema.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appcinema.model.CardModel
import com.example.appcinema.ui.screens.allMoviesScreen.MoviesViewModel
import com.example.appcinema.ui.screens.allSeriesScreen.SeriesViewModel
import com.example.appcinema.ui.theme.BackgroundColor

@Composable
fun AllMoviesCards(listAll: Array<CardModel>, navHostController: NavHostController, viewModel: MoviesViewModel){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(135.dp),
        modifier = Modifier.background(BackgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center,
        userScrollEnabled = true
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
        item(span = { GridItemSpan(maxLineSpan) }) {
            NavigationPageButton { viewModel.nextPage() }
        }
    }
}


package com.example.appcinema.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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
import com.example.appcinema.ui.components.NavigationPageButton
import com.example.appcinema.ui.components.TopBar
import com.example.appcinema.ui.theme.BackgroundColor
import detailsMovieScreenRoute
import detailsSeriesScreenRoute

@Composable
fun HomeScreen(navController: NavHostController){
    val viewModel = viewModel<HomeViewModel>()
    val listAllMovies = viewModel.listAllMovies
    val listAllSeries = viewModel.listAllSeries
    val listAllMoviesFavorite = viewModel.listAllMoviesFavorite
    val listAllSeriesFavorite = viewModel.listAllSeriesFavorite
    Scaffold(
        topBar = { TopBar(navController) },
        modifier = Modifier
            .systemBarsPadding()
            .background(Color.DarkGray)
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .background(BackgroundColor)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
            if (!listAllMoviesFavorite.isNullOrEmpty() || !listAllSeriesFavorite.isNullOrEmpty() || !listAllSeries.isNullOrEmpty() || !listAllMovies.isNullOrEmpty()) {
                AllMCardsHome(listAllMoviesFavorite,listAllSeriesFavorite,listAllSeries,listAllMovies,navController, viewModel)
            }
        }
    }
}

@Composable
fun AllMCardsHome(listAllMoviesFavorite: Array<CardModel>? = null, listAllSeriesFavorite: Array<CardModel>? = null, listAllSeries: Array<CardModel>? = null, listAllMovies: Array<CardModel>? = null, navHostController: NavHostController, viewModel: HomeViewModel){
    Text(text = "Seus favoritos", modifier = Modifier.fillMaxWidth(), color = Color.White)
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier.height(200.dp)
    ) {
        listAllMoviesFavorite?.size?.let {
            items(it) { item ->
                Card(
                    Modifier
                        .padding(7.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                        .clip(RoundedCornerShape(4.dp))
                        .clickable { navHostController.navigate("$detailsMovieScreenRoute/${listAllMoviesFavorite.get(item).id}") }
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data("https://image.tmdb.org/t/p/w500${listAllMoviesFavorite.get(item).poster_path}")
                            .crossfade(true)
                            .build(),
                        contentDescription = "CardFilms",
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
        listAllSeriesFavorite?.let {
            items(it.size) { item ->
                Card(
                    Modifier
                        .padding(7.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                        .clip(RoundedCornerShape(4.dp))
                        .clickable { navHostController.navigate("$detailsSeriesScreenRoute/${listAllSeriesFavorite[item].id}") }
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data("https://image.tmdb.org/t/p/w500${listAllSeriesFavorite[item].poster_path}")
                            .crossfade(true)
                            .build(),
                        contentDescription = "CardFilms",
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            NavigationPageButton { viewModel.nextPageSeriesFavorite() }
        }
    }

    Text(text = "Series populares", modifier = Modifier.fillMaxWidth(), color = Color.White)

    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier.height(200.dp)
    )  {
        listAllSeries?.let {
            items(it.size) { item ->
                Card(
                    Modifier
                        .padding(7.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                        .clip(RoundedCornerShape(4.dp))
                        .clickable { navHostController.navigate("$detailsSeriesScreenRoute/${listAllSeries[item].id}") }
                        .fillMaxWidth()
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data("https://image.tmdb.org/t/p/w500${listAllSeries[item].poster_path}")
                            .crossfade(true)
                            .build(),
                        contentDescription = "CardFilms",
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            NavigationPageButton { viewModel.nextPageSeries() }
        }
    }
    Text(text = "Filmes populares", modifier = Modifier.fillMaxWidth(), color = Color.White)
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier.height(200.dp)
    ) {
        listAllMovies?.let {
            items(it.size) { item ->
                Card(
                    Modifier
                        .padding(7.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                        .clip(RoundedCornerShape(4.dp))
                        .clickable { navHostController.navigate("$detailsMovieScreenRoute/${listAllMovies[item].id}") }
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data("https://image.tmdb.org/t/p/w500${listAllMovies[item].poster_path}")
                            .crossfade(true)
                            .build(),
                        contentDescription = "CardFilms",
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            NavigationPageButton { viewModel.nextPageMovies() }
        }
    }
}
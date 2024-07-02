
package com.example.appcinema.ui.screens.detailsSeriesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appcinema.model.DetailsModel
import com.example.appcinema.ui.components.TopBar
import com.example.appcinema.ui.screens.detailsMoviesScreen.ButtonFavorite
import com.example.appcinema.ui.screens.detailsMoviesScreen.DetailsMovies
import com.example.appcinema.ui.screens.detailsMoviesScreen.DetailsMoviesViewModel

@Composable
fun DetailsSeriesScreen(navController: NavHostController, idCard: Int) {
    val viewModel = viewModel<DetailsSeriesViewModel>()
    viewModel.getDetailsFun(idCard)
    val cardDetails = viewModel.cardDetails
    Scaffold(
        topBar = { TopBar(navController) },
        modifier = Modifier
            .systemBarsPadding()
            .background(Color.DarkGray)
    ) { innerPadding ->
        if(cardDetails != null){
            Box(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
            ){
                Box(modifier = Modifier.fillMaxSize()){
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data("https://image.tmdb.org/t/p/w500${cardDetails.poster_path}")
                            .crossfade(true)
                            .build(),
                        contentDescription = "CardSeries",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.horizontalGradient(
                                    listOf(
                                        Color.Black,
                                        Color.Transparent
                                    )
                                )
                            ),
                    )
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.horizontalGradient(
                                listOf(Color.Black, Color.Transparent),
                                startX = 200f
                            )
                        )
                    ){}
                    DetailsSeries(cardDetails, viewModel, idCard)
                }
            }
        }
    }
}

@Composable
fun DetailsSeries(cardDetails: DetailsModel, viewModel: DetailsSeriesViewModel, idCard: Int){
    val nome = cardDetails.name
    val data = cardDetails.first_air_date
    val overview = cardDetails.overview
    val rating = cardDetails.vote_average.toString()
    Column(
        Modifier.fillMaxSize().padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start){
        Text(
            text = nome,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Row {
            Text(
                text = data,
                fontSize = 14.sp,
                color = Color.White,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = rating,
                fontSize = 14.sp,
                color = Color.White,
                fontStyle = FontStyle.Italic
            )
        }
        Text(
            text = overview,
            fontSize = 16.sp,
            color = Color.White,
        )
        ButtonFavoriteSerie(viewModel,idCard)
    }
}

@Composable
fun ButtonFavoriteSerie(viewModel: DetailsSeriesViewModel, idCard: Int){

    Button(onClick = { viewModel.setFavorite(idCard, "tv") }) {
        Text("Add to Favorite")
    }
}
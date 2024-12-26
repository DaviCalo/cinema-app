package com.example.appcinema.ui.screens.detailsMoviesScreen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appcinema.model.DetailsModel
import com.example.appcinema.ui.components.TopBar
import com.example.appcinema.ui.theme.Purple40
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun DetailsMoviesScreen(navController: NavHostController, idCard: Int) {
    val viewModel = viewModel<DetailsMoviesViewModel>()
    viewModel.getDetailsFun(idCard)
    val cardDetails = viewModel.cardDetails
    Scaffold(
        topBar = { TopBar(navController) },
        modifier = Modifier
            .systemBarsPadding()
            .background(Color.DarkGray)
    ) { innerPadding ->
        if (cardDetails != null) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
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
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.horizontalGradient(
                                    listOf(Color.Black, Color.Transparent),
                                    startX = 200f
                                )
                            )
                    ) {}
                    DetailsMovies(cardDetails, viewModel, idCard)
                }
            }
        }
    }
}

@Composable
fun DetailsMovies(cardDetails: DetailsModel, viewModel: DetailsMoviesViewModel, idCard: Int) {
    val nome = cardDetails.title
    val data = cardDetails.release_date
    val overview = cardDetails.overview
    val rating = cardDetails.vote_average.toString()
    val favorite = viewModel.isFavorite
    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
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
        ButtonFavorite(viewModel, idCard, favorite)
    }
}

@Composable
fun ButtonFavorite(viewModel: DetailsMoviesViewModel, idCard: Int, favorite: Boolean) {
    var isFavorite by remember { mutableStateOf(favorite) }
    var showModal by remember { mutableStateOf(false) }


    Row {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = if (isFavorite) Color.Red else Purple40),
            onClick = {
                isFavorite = !isFavorite
                viewModel.setFavorite(idCard, "movie", isFavorite)

            }
        ) {
            val icon = if (isFavorite) Icons.Filled.Favorite else Icons.Default.FavoriteBorder
            Icon(imageVector = icon, contentDescription = null)
            Spacer(modifier = Modifier.padding(4.dp))
            Text("Favorito")
        }
        Spacer(modifier = Modifier.padding(8.dp))

        Button(colors = ButtonDefaults.buttonColors(containerColor = Purple40),
            onClick = {
                showModal = true
            }) {
            Icon(imageVector = Icons.Filled.Movie, contentDescription = null)
            Spacer(modifier = Modifier.padding(4.dp))
            Text("Ver Trailer")
        }
    }

    if (showModal) {
        VideoModal(
            onDismiss = { showModal = false },
            videoId = viewModel.cardTrailer

        )
    }
}

@Composable
fun VideoModal(onDismiss: () -> Unit, videoId: String) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnClickOutside = true)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
                .background(Color.White, shape = MaterialTheme.shapes.medium)
        ) {
            TrailerYoutube(idTrailer = videoId)
        }
    }
}

@Composable
fun TrailerYoutube(idTrailer: String) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        YoutubePlayer(idTrailer, LocalLifecycleOwner.current)
    }
}

@Composable
fun YoutubePlayer(trailerId: String, lifecycleOwner: LifecycleOwner) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        factory = { context ->
            YouTubePlayerView(context = context).apply {
                lifecycleOwner.lifecycle.addObserver(this)
                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.loadVideo(trailerId, 0f)
                    }
                })
            }
        }
    )
}

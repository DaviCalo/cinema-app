package com.example.appcinema.ui.screens.homeScreen

import android.graphics.Movie
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    title: String = "Destaques do dia",
    products: List<Movie> = emptyList(),
    onNavigateToCheckout: () -> Unit = {},
    onNavigateToDetails: () -> Unit = {}
)  {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.Gray),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item{
            Box{
                Modifier.fillMaxSize()
            }
        }
    }



}
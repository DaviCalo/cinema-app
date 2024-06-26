package com.example.appcinema

import android.graphics.Movie
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcinema.ui.theme.Black
import com.example.appcinema.ui.theme.Grey

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
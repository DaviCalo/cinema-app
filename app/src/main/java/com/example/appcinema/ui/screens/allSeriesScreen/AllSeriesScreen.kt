package com.example.appcinema.ui.screens.allSeriesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appcinema.ui.components.AllSeriesCards
import androidx.navigation.NavHostController
import com.example.appcinema.ui.theme.BackgroundColor
import com.example.appcinema.ui.components.TopBar

@Composable
fun AllSeriesScreen(navController: NavHostController) {
    val viewModel = viewModel<SeriesViewModel>()
    val listAllSeries = viewModel.listAllSeries
    Scaffold(
        topBar = { TopBar(navController) },
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
                text = "Series mais populares",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
            if (!listAllSeries.isNullOrEmpty()) {
                AllSeriesCards(listAllSeries,  navController)
            }
        }
    }
}
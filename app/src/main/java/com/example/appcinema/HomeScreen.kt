package com.example.appcinema

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcinema.ui.theme.Black
import com.example.appcinema.ui.theme.Grey

@Preview
@Composable
fun HomeScreen() {
    Box {
        Box(
            modifier = Modifier
               .fillMaxSize()
               .background(Grey)
               .padding(10.dp)
        ) {

        }
    }

}
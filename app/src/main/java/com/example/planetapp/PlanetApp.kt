package com.example.planetapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.planetapp.ui.screen.HomeScreen
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun PlanetApp(
    modifier: Modifier = Modifier
        .fillMaxWidth()

) {
    HomeScreen()
}

@Preview
@Composable
fun PlanetAppPreview() {
    PlanetAppTheme {
        PlanetApp()
    }
}
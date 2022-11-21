package com.example.planetapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planetapp.ui.common.BottomBar
import com.example.planetapp.ui.navigation.Screen
import com.example.planetapp.ui.screen.FavoriteScreen
import com.example.planetapp.ui.screen.HomeScreen
import com.example.planetapp.ui.screen.ProfileScreen
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun PlanetApp(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    navController : NavHostController = rememberNavController()

) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){
                HomeScreen()
            }
            composable(Screen.Favorite.route){
                FavoriteScreen()
            }
            composable(Screen.Profile.route){
                ProfileScreen()
            }
        }
    }
//    HomeScreen()
}

@Preview
@Composable
fun PlanetAppPreview() {
    PlanetAppTheme {
        PlanetApp()
    }
}
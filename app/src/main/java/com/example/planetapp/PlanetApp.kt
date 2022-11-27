package com.example.planetapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.planetapp.ui.common.BottomBar
import com.example.planetapp.ui.detail.DetailScreen
import com.example.planetapp.ui.navigation.Screen
import com.example.planetapp.ui.screen.FavoriteScreen
import com.example.planetapp.ui.screen.HomeScreen
import com.example.planetapp.ui.screen.ProfileScreen
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun PlanetApp(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    navController: NavHostController = rememberNavController()

) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Detail.route) {
                BottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { data ->
                        navController.navigate(Screen.Detail.createRoute(data))
                    }
                )
            }
            composable(Screen.Favorite.route) {
                FavoriteScreen(
                    navigateToDetail = {data ->
                        navController.navigate(Screen.DetailF.createRoute(data))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                Screen.Detail.route,
                arguments = listOf(navArgument("detailId") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("detailId") ?: -1
                DetailScreen(
                    detailId = id,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
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
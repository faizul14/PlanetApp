package com.example.planetapp.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBar
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBarItem
import com.example.planetapp.R
import com.example.planetapp.ui.navigation.BottomBatItem
import com.example.planetapp.ui.navigation.Screen
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    BubbleNavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            BottomBatItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            BottomBatItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite,
                screen = Screen.Favorite
            ),
            BottomBatItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )
        navigationItems.forEach { navigationItem ->
            BubbleNavigationBarItem(
//                selected = navigationItem.title == navigationItem.title,
                selected = currentRoute == navigationItem.screen.route,
                onClick = {
                    navController.navigate(navigationItem.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = navigationItem.icon,
                title = navigationItem.title,
                selectedColor = Color(0xFF2a9d8f)
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    PlanetAppTheme {
//        BottomBar(
//            navController =
//        )
    }
}
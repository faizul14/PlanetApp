package com.example.planetapp.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBar
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBarItem
import com.example.planetapp.R
import com.example.planetapp.ui.model.BottomBatItem
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {

    BubbleNavigationBar {
        val navigationItems = listOf(
            BottomBatItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomBatItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomBatItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            ),
        )
        navigationItems.forEach { navigationItem ->
            BubbleNavigationBarItem(
                selected = navigationItem.title == navigationItem.title,
                onClick = {
                },
                icon = navigationItem.icon,
                title = navigationItem.title,
                selectedColor = Color(0xFF2a9d8f)
            )
        }
    }
}

sealed class NavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val selectedColor: Color,
) {
    object ScreenA : NavigationItem(
        title = "Home",
        route = "screenA",
        icon = Icons.Default.Home,
        selectedColor = Color(0xFF2a9d8f)
    )

    object ScreenB : NavigationItem(
        title = "Search",
        route = "screenB",
        icon = Icons.Default.Search,
        selectedColor = Color(0xFFe9c46a)
    )

    object ScreenC : NavigationItem(
        title = "Shop",
        route = "screenC",
        icon = Icons.Default.ShoppingCart,
        selectedColor = Color(0xFFf4a261)
    )

    object ScreenD : NavigationItem(
        title = "Settings",
        route = "screenD",
        icon = Icons.Default.Settings,
        selectedColor = Color(0xFFe76f51)
    )
}

@Preview
@Composable
fun BottomBarPreview() {
    PlanetAppTheme {
        BottomBar()
    }
}
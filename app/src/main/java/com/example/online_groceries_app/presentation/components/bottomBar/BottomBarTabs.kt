package com.example.online_groceries_app.presentation.components.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarTab(val title: String, val icon: ImageVector, val color: Color, val route: String) {
    data object Home : BottomBarTab(
        title = "Home",
        icon = Icons.Rounded.Home,
        color = Color.Black,
        route = "home"
    )
    data object Explorer : BottomBarTab(
        title = "Explorer",
        icon = Icons.Rounded.Email,
        color = Color.Black,
        route = "explore"
    )
    data object Cart : BottomBarTab(
        title = "Cart",
        icon = Icons.Rounded.ShoppingCart,
        color = Color.Black,
        route = "sigin"
    )
    data object Favourite : BottomBarTab(
        title = "Explorer",
        icon = Icons.Rounded.FavoriteBorder,
        color = Color.Black,
        route = "splash"
    )
    data object Profile : BottomBarTab(
        title = "Profile",
        icon = Icons.Rounded.Person,
        color = Color.Black,
        route = "onBoarding"
    )
}

val tabs = listOf(
    BottomBarTab.Home,
    BottomBarTab.Explorer,
    BottomBarTab.Cart,
    BottomBarTab.Favourite,
    BottomBarTab.Profile,
)
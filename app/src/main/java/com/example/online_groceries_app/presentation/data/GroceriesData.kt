package com.example.online_groceries_app.presentation.data

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class GroceriesData(
    val groceriesId: Int,
    @DrawableRes val image: Int,
    @ColorRes val color: Int,
    val title: String,
)

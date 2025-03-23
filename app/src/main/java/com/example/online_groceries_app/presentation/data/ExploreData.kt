package com.example.online_groceries_app.presentation.data

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class ExploreData(
    @DrawableRes val image: Int,
    val title: String,
    @ColorRes val color: Int,
    @ColorRes val borderColor: Int
)

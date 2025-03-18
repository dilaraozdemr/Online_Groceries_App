package com.example.online_groceries_app.presentation.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
    @StringRes val contentDescriptionResId: Int
)

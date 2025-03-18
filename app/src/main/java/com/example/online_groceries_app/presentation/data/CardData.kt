package com.example.online_groceries_app.presentation.data

import androidx.annotation.DrawableRes

data class CardData(
    @DrawableRes val imageResId: Int,
    val title: String,
    val desc: String,
    val amount: Double,
)




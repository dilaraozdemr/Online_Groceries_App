package com.example.online_groceries_app.presentation.data

import androidx.annotation.DrawableRes

data class CardData(
    val cardId: Int,
    @DrawableRes val imageResId: Int,
    val total: Int,
    val productDetail: String,
    val title: String,
    val desc: String,
    val amount: Double,
)




package com.example.online_groceries_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.online_groceries_app.R


public val gilroyFamily = FontFamily(
    Font(R.font.gilroy_bold, FontWeight.Bold),
    Font(R.font.gilroy_regular, FontWeight.W400),
    Font(R.font.gilroy_light, FontWeight.Light),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = gilroyFamily,
        fontWeight = FontWeight.W400
    ),
    titleLarge = TextStyle(
        fontFamily = gilroyFamily,
        fontWeight = FontWeight.Bold,
    ),
    titleMedium = TextStyle(
        fontFamily = gilroyFamily,
        fontWeight = FontWeight.SemiBold,
    ),
)
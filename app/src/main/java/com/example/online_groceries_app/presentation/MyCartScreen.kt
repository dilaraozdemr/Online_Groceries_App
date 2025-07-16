package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.ButtonWidget
import com.example.online_groceries_app.presentation.components.MyCartWidget
import com.example.online_groceries_app.presentation.data.CardData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyCartScreen(modifier: Modifier = Modifier) {
    val cardData = listOf(
        CardData(
            imageResId = R.drawable.redpepper,
            title = "Organic Red Pepper",
            amount = 6.99,
            desc = "7pcs, Priceg",
            cardId = 1,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.artichoke,
            title = "Artichoke",
            amount = 21.99,
            desc = "7pcs, Priceg",
            cardId = 2,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.artichoke,
            title = "Artichoke",
            amount = 21.99,
            desc = "7pcs, Priceg",
            cardId = 2,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.artichoke,
            title = "Artichoke",
            amount = 21.99,
            desc = "7pcs, Priceg",
            cardId = 2,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.artichoke,
            title = "Artichoke",
            amount = 21.99,
            desc = "7pcs, Priceg",
            cardId = 2,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.artichoke,
            title = "Artichoke",
            amount = 21.99,
            desc = "7pcs, Priceg",
            cardId = 2,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.artichoke,
            title = "Artichoke",
            amount = 21.99,
            desc = "7pcs, Priceg",
            cardId = 2,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.artichoke,
            title = "Artichoke",
            amount = 21.99,
            desc = "7pcs, Priceg",
            cardId = 2,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
        CardData(
            imageResId = R.drawable.banana,
            title = "Organic Bananas",
            amount = 4.99,
            desc = "7pcs, Priceg",
            cardId = 3,
            productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
            total = 1
        ),
    )

    Scaffold(
        modifier = modifier.background(Color.White)
    ) { contentPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Text(
                text = "My Cart",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                ),
                modifier = Modifier.padding(all = 10.dp)
            )
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                items(cardData) { item ->
                    MyCartWidget(
                        cardData = item,
                        modifier = Modifier.padding(all = 10.dp)
                    )
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    )
                }
            }
            ButtonWidget(
                text = "Go To Checkout",
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth()
            )
        }
    }
}

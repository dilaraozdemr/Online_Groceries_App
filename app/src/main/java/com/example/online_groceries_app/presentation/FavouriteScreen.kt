package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.online_groceries_app.presentation.components.FavouriteWidget
import com.example.online_groceries_app.presentation.data.CardData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavouriteScreen(){
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
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White
    ) {contentPadding->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(contentPadding)
        ) {
            Text(
                text = "Favourite",
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
                    .padding(horizontal = 10.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {items(cardData) { item ->
                    FavouriteWidget(
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
                text = "Add All To Cart",
                onClick = {
                    showDialog = true
                },
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth()
            )
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Success") },
                text = { Text("All items have been added to your cart.") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
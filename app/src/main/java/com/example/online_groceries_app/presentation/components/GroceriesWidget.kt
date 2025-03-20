package com.example.online_groceries_app.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.data.CardData
import com.example.online_groceries_app.presentation.data.GroceriesData

@Composable
fun GroceriesWidget(modifier: Modifier = Modifier, navController: NavHostController) {
    val cards =
        listOf(
            CardData(
                imageResId = R.drawable.meat,
                title = "Meat",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 1,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.meat,
                title = "Meat",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 2,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.meat,
                title = "Meat",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 3,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.meat,
                title = "Meat",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 4,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.meat,
                title = "Meat",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 5,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.meat,
                title = "Meat",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 6,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.meat,
                title = "Meat",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 7,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
        )
    val groceries = listOf(
        GroceriesData(
            color = R.color.groceries_one,
            title = "Pulses",
            image = R.drawable.pulses,
            groceriesId = 1
        ),
        GroceriesData(
            color = R.color.groceries_two,
            title = "Pulses",
            image = R.drawable.pulses,
            groceriesId = 2
        ),
        GroceriesData(
            color = R.color.groceries_three,
            title = "Pulses",
            image = R.drawable.meat,
            groceriesId = 3
        ),
        GroceriesData(
            color = R.color.groceries_four,
            title = "Pulses",
            image = R.drawable.meat,
            groceriesId = 4
        )
    )

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Groceries", style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = stringResource(id = R.string.seeAll), style = TextStyle(
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.splash_background_green),
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(groceries) { card ->
                Groceries(groceries = card)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(cards) { card ->
                CardWidget(card = card, navController = navController)
            }
        }
    }


}
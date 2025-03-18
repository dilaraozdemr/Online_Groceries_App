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
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.data.CardData
import com.example.online_groceries_app.presentation.data.GroceriesData

@Preview
@Composable
fun GroceriesWidget(modifier: Modifier = Modifier) {
    val cards =
        listOf(
            CardData(
                imageResId = R.drawable.banana,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg"
            ),
            CardData(
                imageResId = R.drawable.banana,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg"
            ),
            CardData(
                imageResId = R.drawable.banana,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg"
            ),
            CardData(
                imageResId = R.drawable.banana,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg"
            ),
            CardData(
                imageResId = R.drawable.banana,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg"
            ),
            CardData(
                imageResId = R.drawable.banana,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg"
            ),
            CardData(
                imageResId = R.drawable.banana,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg"
            ),
        )
    val groceries = listOf(
        GroceriesData(
            color = R.color.groceries_one,
            title = "Pulses",
            image = R.drawable.pulses
        ),
        GroceriesData(
            color = R.color.groceries_two,
            title = "Pulses",
            image = R.drawable.pulses
        ),
        GroceriesData(
            color = R.color.groceries_three,
            title = "Pulses",
            image = R.drawable.meat
        ),
        GroceriesData(
            color = R.color.groceries_four,
            title = "Pulses",
            image = R.drawable.meat
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
                CardWidget(card = card)
            }
        }
    }


}
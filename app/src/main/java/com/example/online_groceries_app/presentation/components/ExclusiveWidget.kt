package com.example.online_groceries_app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.example.online_groceries_app.presentation.data.CarouselItem

@Composable
fun ExclusiveWidget(modifier: Modifier = Modifier, navController: NavHostController) {
    val cards =
        listOf(
            CardData(
                imageResId = R.drawable.apple,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 1,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.apple,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 2,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.apple,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 3,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.apple,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 4,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.apple,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 5,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.apple,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 6,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
            CardData(
                imageResId = R.drawable.apple,
                title = "Organic Bananas",
                amount = 4.99,
                desc = "7pcs, Priceg",
                cardId = 7,
                productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                total = 1
            ),
        )

    val pagerState = rememberPagerState(pageCount = { cards.size })

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Exclusive Offer", style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            )
            Text(
                modifier = Modifier.clickable {  },
                text = stringResource(id = R.string.seeAll), style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.splash_background_green)
                )
            )
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
package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.ExploreWidget
import com.example.online_groceries_app.presentation.components.SearchBarWidget
import com.example.online_groceries_app.presentation.data.CardData
import com.example.online_groceries_app.presentation.data.CarouselItem
import com.example.online_groceries_app.presentation.data.ExploreData

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val scrollState = rememberScrollState()
    val images =
        listOf(
            CarouselItem(0, R.drawable.banner, R.string.signup_desc),
            CarouselItem(1, R.drawable.banner, R.string.signup_desc),
            CarouselItem(2, R.drawable.banner, R.string.signup_desc),
            CarouselItem(3, R.drawable.banner, R.string.signup_desc),
            CarouselItem(4, R.drawable.banner, R.string.signup_desc),
        )
    val pagerState = rememberPagerState(pageCount = { images.size })
    var active by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var items = remember {
        mutableStateListOf(
            "Coca Cola",
            "Tomato",
            "Banana"
        )
    }
    val exploreWidget = listOf(
        ExploreData(
            title = "Frash Fruits & Vegetable",
            color = R.color.fruits,
            image = R.drawable.fruits,
            borderColor = R.color.fruits_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
        ExploreData(
            title = "Cooking Oil & Ghee",
            color = R.color.oil,
            image = R.drawable.oil,
            borderColor = R.color.oil_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
        ExploreData(
            title = "Meat & Fish",
            color = R.color.fish,
            image = R.drawable.meatfish,
            borderColor = R.color.fish_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
        ExploreData(
            title = "Bakery & Snacks",
            color = R.color.bakery,
            image = R.drawable.bakery,
            borderColor = R.color.bakery_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
        ExploreData(
            title = "Dairy & Eggs",
            color = R.color.dairy,
            image = R.drawable.dairy,
            borderColor = R.color.dairy_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
        ExploreData(
            title = "Beverages",
            color = R.color.beverages,
            image = R.drawable.beverages,
            borderColor = R.color.beverages_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
        ExploreData(
            title = "Frash Fruits & Vegetable",
            color = R.color.purple,
            image = R.drawable.fruits,
            borderColor = R.color.purple_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
        ExploreData(
            title = "Frash Fruits & Vegetable",
            color = R.color.pink,
            image = R.drawable.bakery,
            borderColor = R.color.pink_border,
            cardDataList = listOf(
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
                    imageResId = R.drawable.banana,
                    title = "Organic Bananas",
                    amount = 4.99,
                    desc = "7pcs, Priceg",
                    cardId = 3,
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
                    cardId = 5,
                    productDetail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    total = 1
                ),
            )
        ),
    )
    Scaffold(
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Find Products", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 18.sp
                )
            )
            SearchBarWidget(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                query = text,
                onQueryChange = {
                    text = it
                },
                onSearch = {
                    items.add(text)
                    active = false
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = {
                    Text("Search Store")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if (active) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    active = false
                                }
                            },
                            imageVector = Icons.Default.Close, contentDescription = "Close Icon"
                        )
                    }
                },
                colors = SearchBarDefaults.colors(
                    containerColor = colorResource(id = R.color.light_grey)
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                items.forEach {
                    Row(
                        modifier = Modifier.padding(14.dp)
                    ) {
                        Icon(
                            modifier = Modifier.padding(end = 10.dp),
                            imageVector = Icons.Default.Menu,
                            contentDescription = "history"
                        )
                        Text(text = it)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                items(exploreWidget) { item ->
                    ExploreWidget(
                        data = item,
                        navController = navController,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}
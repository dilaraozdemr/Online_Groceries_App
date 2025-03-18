package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.BestSellingWidget
import com.example.online_groceries_app.presentation.components.ExclusiveWidget
import com.example.online_groceries_app.presentation.components.GroceriesWidget
import com.example.online_groceries_app.presentation.components.SearchBarWidget
import com.example.online_groceries_app.presentation.components.bottomBar.BottomBarTab
import com.example.online_groceries_app.presentation.data.CarouselItem
import dev.chrisbanes.haze.HazeState

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@Composable
@Preview
fun HomeScreen(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val scrollState = rememberScrollState()
    val screenWidth = configuration.screenWidthDp.dp

    val coroutineScope = rememberCoroutineScope()
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember {
        mutableStateListOf(
            "Coca Cola",
            "Tomato",
            "Banana"
        )
    }
    val images =
        listOf(
            CarouselItem(0, R.drawable.banner, R.string.signup_desc),
            CarouselItem(1, R.drawable.banner, R.string.signup_desc),
            CarouselItem(2, R.drawable.banner, R.string.signup_desc),
            CarouselItem(3, R.drawable.banner, R.string.signup_desc),
            CarouselItem(4, R.drawable.banner, R.string.signup_desc),
        )

    val pagerState = rememberPagerState(pageCount = { images.size })

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.color_icon),
                contentDescription = "icon"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.exclude),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Dhaka, Banassre", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            SearchBarWidget(
                modifier = Modifier
                    .fillMaxWidth(),
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
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = images[page].imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(205.dp),
                        contentScale = ContentScale.Fit
                    )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .align(Alignment.BottomEnd)
                        ) {
                            images.indices.forEach { index ->
                                val isSelected = pagerState.currentPage == index
                                Box(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .height(10.dp)
                                        .width(if (isSelected) 20.dp else 10.dp)
                                        .background(
                                            color = if (isSelected) colorResource(id = R.color.splash_background_green) else Color.Gray,
                                            shape = RoundedCornerShape(50)
                                        )
                                )
                            }
                        }

                }

            }
            Spacer(modifier = Modifier.height(30.dp))
            ExclusiveWidget()
            Spacer(modifier = Modifier.height(30.dp))
            BestSellingWidget()
            Spacer(modifier = Modifier.height(30.dp))
            GroceriesWidget()
        }
    }
}




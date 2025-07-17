package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.ButtonWidget
import com.example.online_groceries_app.presentation.data.CardData
import com.skydoves.cloudy.cloudy

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    cardData: CardData, navHostController: NavHostController,
) {
    Scaffold(
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxSize(),
        ) {

        val scrollState = rememberScrollState()
        var totalCard by remember { mutableIntStateOf(cardData.total) }
        var amountCard by remember { mutableDoubleStateOf(cardData.amount) }
        var isProductDetailExpanded by remember { mutableStateOf(true) }
        var isNutritionExpanded by remember { mutableStateOf(false) }
        var isReviewExpanded by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier
                        .padding(top = 35.dp, start = 25.dp, end = 25.dp)
                        .size(30.dp)
                        .clickable { navHostController.popBackStack() },
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft, contentDescription = "back"
                )

                Icon(
                    modifier = Modifier
                        .padding(top = 35.dp, start = 25.dp, end = 25.dp)
                        .size(30.dp),
                    imageVector = Icons.Default.Share, contentDescription = "back"
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .cloudy(radius = 1000)
                        .padding(30.dp)
                        .fillMaxWidth(),
                    painter = painterResource(id = cardData.imageResId),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    painter = painterResource(id = cardData.imageResId),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = cardData.formattedTitle, style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 18.sp,
                            letterSpacing = 0.1.sp,
                        )
                    )
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder, contentDescription = "", tint = colorResource(
                        id = R.color.grey
                    ))
                }
                Spacer(modifier = Modifier.height(10.5.dp))
                Text(
                    text = "1 kg, Price", style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        color = colorResource(id = R.color.grey)
                    )
                )
                Spacer(modifier = Modifier.height(30.14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (totalCard == 0) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "minus",
                                tint = colorResource(
                                    id = R.color.grey
                                )
                            )
                        } else {
                            Icon(
                                modifier = Modifier.clickable {
                                    totalCard -= 1
                                    amountCard -= cardData.amount
                                },
                                imageVector = Icons.Filled.Close,
                                contentDescription = "minus",
                                tint = colorResource(
                                    id = R.color.grey
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = colorResource(id = R.color.light_grey),
                                    shape = RoundedCornerShape(17.dp)
                                )
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp),
                                text = "${totalCard}", style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            modifier = Modifier.clickable {
                                totalCard += 1
                                amountCard += cardData.amount
                            },
                            imageVector = Icons.Filled.Add,
                            contentDescription = "add",
                            tint = colorResource(id = R.color.splash_background_green)
                        )
                    }
                    Text(
                        text = "$${String.format("%.2f", amountCard)}", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .height(1.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Product Detail", style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { isProductDetailExpanded = !isProductDetailExpanded },
                        imageVector = if (isProductDetailExpanded) Icons.Default.KeyboardArrowDown else Icons.AutoMirrored.Default.KeyboardArrowRight,
                        contentDescription = ""
                    )
                }
                if (isProductDetailExpanded) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = cardData.formattedProductDetail, style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .height(1.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Nutritions", style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.background(
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(5.dp)
                        )){
                            Text(
                                modifier = Modifier.padding(vertical = 5.dp, horizontal = 4.dp),
                                text = "100gr", style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 9.sp,
                                color = colorResource(id = R.color.grey)
                            ))
                        }
                        Spacer(modifier = Modifier.width(15.dp))
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable { isReviewExpanded = !isReviewExpanded },
                            imageVector = if (isReviewExpanded) Icons.Default.KeyboardArrowDown else Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = ""
                        )
                    }
                }
                if (isNutritionExpanded) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = cardData.formattedProductDetail, style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .height(1.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Review", style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.star
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.star
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.star
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.star
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = colorResource(
                                id = R.color.star
                            )
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable { isReviewExpanded = !isReviewExpanded },
                            imageVector = if (isReviewExpanded) Icons.Default.KeyboardArrowDown else Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = ""
                        )
                    }
                }
                if (isReviewExpanded) {
                    Text(
                        text = cardData.formattedProductDetail, style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                ButtonWidget(text = "Add To Basket", onClick = {})
                Spacer(modifier = Modifier.height(40.dp))
            }
        }

    }
}
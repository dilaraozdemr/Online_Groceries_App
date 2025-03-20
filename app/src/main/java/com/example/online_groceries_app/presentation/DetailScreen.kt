package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.ButtonWidget
import com.skydoves.cloudy.cloudy

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    cardId: Int,
    title: String,
    desc: String,
    amount: Double,
    imageResId: Int,
    total: Int,
    productDetail: String,
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),

        ) {

        val scrollState = rememberScrollState()
        var totalCard = remember { mutableStateOf(total) }
        var amountCard = remember { mutableStateOf(amount) }
        var productDetailBool = remember { mutableStateOf(true) }
        var nutritionsBool = remember { mutableStateOf(true) }
        var reviewBool = remember { mutableStateOf(true) }

        Column {
            Box(modifier = modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .cloudy(radius = 1000)
                        .padding(30.dp)
                        .fillMaxWidth(),
                    painter = painterResource(id = imageResId),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    painter = painterResource(id = imageResId),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
                Icon(
                    modifier = Modifier
                        .padding(25.dp)
                        .clickable { navHostController.popBackStack() },
                    imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "back"
                )

                Icon(
                    modifier = Modifier
                        .padding(25.dp)
                        .align(Alignment.TopEnd),
                    imageVector = Icons.Default.Share, contentDescription = "back"
                )
            }
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(horizontal = 20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title, style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 18.sp,
                            letterSpacing = 0.1.sp,
                        )
                    )
                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "")
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
                        if (totalCard.value == 0) {
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
                                    totalCard.value -= 1
                                    amountCard.value = amountCard.value - amount
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
                                    color = colorResource(id = R.color.grey),
                                    shape = RoundedCornerShape(17.dp)
                                )
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp),
                                text = "${totalCard.value}", style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            modifier = Modifier.clickable {
                                totalCard.value += 1
                                amountCard.value = amountCard.value + amount
                            },
                            imageVector = Icons.Filled.Add,
                            contentDescription = "add",
                            tint = colorResource(id = R.color.splash_background_green)
                        )
                    }
                    Text(
                        text = "$${String.format("%.2f", amountCard.value)}", style = TextStyle(
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
                            .clickable { productDetailBool.value = !productDetailBool.value },
                        imageVector = if (productDetailBool.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowDown,
                        contentDescription = ""
                    )
                }
                if (productDetailBool.value) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = productDetail, style = TextStyle(
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
                        text = "Product Detail", style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { nutritionsBool.value = !nutritionsBool.value },
                        imageVector = if (nutritionsBool.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowDown,
                        contentDescription = ""
                    )
                }
                if (nutritionsBool.value) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = productDetail, style = TextStyle(
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
                                .clickable { reviewBool.value = !reviewBool.value },
                            imageVector = if (reviewBool.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowDown,
                            contentDescription = ""
                        )
                    }

                }
                if (reviewBool.value) {
                    Text(
                        text = productDetail, style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    )
                }
                ButtonWidget(text = "Add To Basket")
            }
        }
    }
}
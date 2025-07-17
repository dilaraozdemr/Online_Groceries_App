package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NumberScreen(
    navController : NavHostController,
    modifier: Modifier = Modifier) {
    var mobileNumber by remember { mutableStateOf("") }
    Scaffold(
        modifier = modifier.imePadding()
    ) {contentPadding->
        Box(
            modifier = Modifier.fillMaxSize().padding(contentPadding)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.number_back),
                contentDescription = "number_back"
            )
            Column{
                IconButton(
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        navController.popBackStack()
                    }) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "arrow",
                    )
                }
                Spacer(modifier = Modifier.height(65.19.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 25.02.dp),
                    text = "Enter your mobile number", style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 29.sp
                ))
                Spacer(modifier = Modifier.height(27.58.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 25.02.dp)
                ) {
                    OutlinedTextField(
                        value = mobileNumber,
                        onValueChange = { newValue ->
                            if (newValue.all { it.isDigit() }) {
                                mobileNumber = newValue
                            }
                        },
                        label = { if (mobileNumber.isNotEmpty()) Text("Mobile Number", style = TextStyle(
                            color = Color.Black
                        )) },
                        leadingIcon = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.flag),
                                    contentDescription = "Flag",
                                    modifier = Modifier
                                        .size(45.dp)
                                        .padding(5.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "+880", style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Medium,
                                        lineHeight = 29.sp,
                                        letterSpacing = 0.sp
                                    )
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        )
                    )
                    Box(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.light_grey),
                                shape = RoundedCornerShape(0.dp)
                            )
                            .height(1.dp)
                            .fillMaxWidth()
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(30.dp)
                    .background(
                        color = colorResource(id = R.color.splash_background_green),
                        shape = CircleShape
                    )
                    .clip(RoundedCornerShape(19.dp))
                    .clickable { navController.navigate("verification") }
                    .size(67.dp)
                    .align(Alignment.BottomEnd)
            ){
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(40.dp),
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "number_arrow",
                    tint = Color.White
                )
            }
        }

    }

}
package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import com.example.online_groceries_app.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun VerificationScreen(modifier: Modifier = Modifier) {
    var codeNumber by remember { mutableStateOf("") }
    Scaffold(
        modifier = modifier.imePadding()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.number_back),
                contentDescription = "number_back"
            )
            Column {
                IconButton(
                    modifier = Modifier.padding(10.dp),
                    onClick = {}) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "arrow",
                    )
                }
                Spacer(modifier = Modifier.height(65.19.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 25.02.dp),
                    text = "Enter your 4-digit code", style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 29.sp
                    )
                )
                Spacer(modifier = Modifier.height(27.58.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 25.02.dp)
                ) {
                    OutlinedTextField(
                        value = codeNumber,
                        onValueChange = { newValue ->
                            if (newValue.all { it.isDigit() } && newValue.length <= 4) {
                                codeNumber = newValue
                            }
                        },
                        label = {
                            Text(text = "-  -  -  -", style = TextStyle(
                                fontSize = 25.sp,
                                fontWeight = FontWeight.W400
                            ))
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Text(
                    modifier = Modifier
                        .padding(30.dp),
                    text = "Resend Code", style = TextStyle(
                        color = colorResource(id = R.color.splash_background_green),
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        lineHeight = 29.sp
                    )
                )
                Spacer(modifier = Modifier.width(100.dp))
                Box(
                    modifier = Modifier
                        .padding(30.dp)
                        .background(
                            color = colorResource(id = R.color.splash_background_green),
                            shape = CircleShape
                        )
                        .size(67.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(40.dp),
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "number_arrow",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

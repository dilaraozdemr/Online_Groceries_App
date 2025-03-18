package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import com.example.online_groceries_app.R

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnboardingPage(modifier: Modifier = Modifier) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = "onboarding"
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "icon",
                modifier = Modifier
                    .width(48.47.dp)
                    .height(56.36.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(id = R.string.onboarding_title_one),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 48.sp,
                    lineHeight = 29.sp,
                    letterSpacing = 0.sp,
                    color = Color.White
                )
            )
            Text(text = stringResource(id = R.string.onboarding_title_two),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 48.sp,
                    lineHeight = 29.sp,
                    letterSpacing = 0.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.onboarding_desc),
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 15.sp,
                    letterSpacing = 0.sp,
                    color = Color.White.copy(0.6f)
                )
            )
            Spacer(modifier = Modifier.height(40.88.dp))
            Box(
                modifier = Modifier
                    .background(
                        shape = RoundedCornerShape(19),
                        color = colorResource(id = R.color.splash_background_green)
                    )
            ){
                Text(
                    modifier = Modifier.padding(
                        horizontal = 127.dp,
                        vertical = 24.5.dp
                    ),
                    text = "Get Started",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 18.sp,
                        letterSpacing = 0.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    ))
            }
            Spacer(modifier = Modifier.height(90.66.dp))
        }
    }
}
package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.ButtonWidget

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OrderAccepted(
    navController: NavHostController,
    modifier: Modifier = Modifier) {
    Scaffold {contentPadding->
        Column(
            modifier.padding(contentPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(200.dp),
                painter = painterResource(R.drawable.accept),
                contentDescription = ""
            )
            Spacer(modifier.height(30.dp))
            Text("Your Order has been accepted", style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                color = Color.Black
            ))
            Spacer(modifier.height(30.dp))
            Text("Your items has been placed and is on \n" + "it’s way to being processed", style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Gray
            ))
            Spacer(modifier.height(100.dp))
            ButtonWidget(onClick = {}, text = "Track Order")
            Spacer(modifier.height(20.dp))
            Text(
                modifier = Modifier.clickable {
                    navController.navigate("account")
                },
                textAlign = TextAlign.Center,
                text = "Back to home", style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ))
        }
    }
}
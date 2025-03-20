package com.example.online_groceries_app.presentation.components

import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.data.CardData

@Composable
fun CardWidget(
    card: CardData,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                color = colorResource(id = R.color.grey),
                width = 1.dp,
                shape = RoundedCornerShape(18.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(18.dp)
            )
            .clickable {
                navController.navigate(
                    "detail/${card.cardId}/${card.title}/${card.desc}/${card.amount}/${card.imageResId}/${card.total}/${card.productDetail}"
                )
            }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
        ){
            Image(
                modifier = Modifier
                    .padding(10.dp)
                    .height(80.dp)
                    .width(100.dp),
                painter = painterResource(id = card.imageResId), contentDescription = "image"
            )
            Spacer(modifier = Modifier.height(25.26.dp))
            Text(
                textAlign = TextAlign.Start,
                text = card.title, style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                textAlign = TextAlign.Start,
                text = card.desc, style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
        }

        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp),
            text = "$${card.amount}", style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        )
        Box(
            modifier = Modifier
                .clickable { }
                .align(Alignment.BottomEnd)
                .padding(5.dp)
                .background(
                    color = colorResource(id = R.color.splash_background_green),
                    shape = RoundedCornerShape(17.dp)
                )) {
            Icon(
                modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp),
                imageVector = Icons.Default.Add, contentDescription = "add",
                tint = Color.White
            )
        }
    }
}
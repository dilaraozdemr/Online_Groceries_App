package com.example.online_groceries_app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.online_groceries_app.presentation.data.ExploreData

@Composable
fun ExploreWidget(
    modifier: Modifier = Modifier,
    data: ExploreData
) {
    Box(
        modifier = modifier
            .background(
                color = colorResource(id = data.color),
                shape = RoundedCornerShape(18.dp)
            )
            .border(
                width = 1.dp,
                color = colorResource(id =data.borderColor) ,
                shape = RoundedCornerShape(18.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 40.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.width(112.dp).height(74.dp),
                painter = painterResource(id = data.image), contentDescription = "image")
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = data.title,
                textAlign = TextAlign.Center,
                maxLines = 2,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    )
            )
        }
    }
}
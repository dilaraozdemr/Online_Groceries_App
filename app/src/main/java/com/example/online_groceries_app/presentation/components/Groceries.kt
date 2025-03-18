package com.example.online_groceries_app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.online_groceries_app.presentation.data.GroceriesData


@Composable
fun Groceries(
    groceries: GroceriesData,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.background(
            color = colorResource(id = groceries.color),
            shape = RoundedCornerShape(18.dp)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 60.dp)
        ) {
            Image(
                modifier = Modifier.size(71.dp),
                painter = painterResource(id = groceries.image), contentDescription = "image"
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = groceries.title, style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

    }

}
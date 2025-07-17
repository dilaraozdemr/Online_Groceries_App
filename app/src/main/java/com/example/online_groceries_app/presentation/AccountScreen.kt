package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.AccountWidget
import com.example.online_groceries_app.presentation.data.MenuItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccountScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier) {
    val menuItems = listOf(
        MenuItem("Orders", Icons.Filled.ShoppingCart),
        MenuItem("My Details", Icons.Filled.Person),
        MenuItem("Delivery Address", Icons.Filled.LocationOn),
        MenuItem("Payment Methods", Icons.Filled.ShoppingCart),
        MenuItem("Promo Card", Icons.Filled.ShoppingCart),
        MenuItem("Notifications", Icons.Filled.Notifications),
        MenuItem("Help", Icons.Filled.Info),
        MenuItem("About", Icons.Filled.Info),
    )
    Scaffold (
        modifier.fillMaxSize(),
        containerColor = Color.White
    )
    {contentPadding ->
        Column(
            modifier.padding(contentPadding).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.alert),
                    contentDescription = "Banana",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)

                )
                Spacer(modifier.width(20.dp))
                Column {
                    Row {
                        Text("Emily Bravo", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        ))
                        Spacer(modifier.width(5.dp))
                        Icon(
                            modifier = Modifier
                                .size(20.dp),
                            imageVector = Icons.Filled.Create, contentDescription = "",
                            tint = colorResource(R.color.fruits_border)
                        )
                    }
                    Text("emily@gmail.com", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    ))

                }

            }
            Spacer(modifier.height(20.dp))
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                items(menuItems) { item ->
                    AccountWidget(
                        title = item.title,
                        icon = item.icon
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(
                        color = colorResource(id = R.color.beverages),
                        shape = RoundedCornerShape(19.dp)
                    )
                    .clickable {}

            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(19.dp))
                        .clickable {
                            navController.navigate("orderAccepted")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Log Out",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            lineHeight = 18.sp,
                            color = colorResource(R.color.fruits_border)
                        )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "",
                            tint = colorResource(R.color.fruits_border)
                        )
                    }
                }

            }
        }

    }
}
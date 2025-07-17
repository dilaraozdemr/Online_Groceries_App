package com.example.online_groceries_app.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutBottomSheetContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text("Checkout", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        CheckoutRow(title = "Delivery", value = "Select Method")
        CheckoutRow(title = "Payment", value = "**** **** 1234")
        CheckoutRow(title = "Promo Code", value = "Pick discount")
        CheckoutRow(title = "Total Cost", value = "$13.97")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "By placing an order you agree to our",
            fontSize = 12.sp,
            color = Color.Gray
        )
        Text(
            text = "Terms And Conditions",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)),
            onClick = { /* Place order */ }
        ) {
            Text("Place Order", color = Color.White)
        }
    }
}

package com.example.online_groceries_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.online_groceries_app.presentation.HomeScreen
import com.example.online_groceries_app.presentation.NumberScreen
import com.example.online_groceries_app.presentation.VerificationScreen
import com.example.online_groceries_app.presentation.components.SearchBarWidget
import com.example.online_groceries_app.ui.theme.Online_Groceries_AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Online_Groceries_AppTheme {
                HomeScreen()
            }
        }
    }
}
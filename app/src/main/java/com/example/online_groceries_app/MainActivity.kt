package com.example.online_groceries_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.online_groceries_app.presentation.components.AppNavigation
import com.example.online_groceries_app.presentation.components.bottomBar.BottomBarNav

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()

            val shouldShowBottomBar by remember {
                derivedStateOf {
                    val route = currentBackStackEntry?.destination?.route
                    route?.startsWith("detail") == false
                }
            }

            Scaffold(
                bottomBar = {
                    AnimatedVisibility(
                        visible = shouldShowBottomBar,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        BottomBarNav(navController)
                    }
                }
            ) {
                AppNavigation(navController)
            }
        }
    }
}
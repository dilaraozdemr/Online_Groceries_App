package com.example.online_groceries_app.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.online_groceries_app.presentation.HomeScreen
import com.example.online_groceries_app.presentation.OnboardingPage
import com.example.online_groceries_app.presentation.SignInScreen
import com.example.online_groceries_app.presentation.SignUpScreen
import com.example.online_groceries_app.presentation.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("signup") { SignUpScreen() }
        composable("sigin") { SignInScreen() }
        composable("splash") { SplashScreen() }
        composable("onBoarding") { OnboardingPage() }
    }
}
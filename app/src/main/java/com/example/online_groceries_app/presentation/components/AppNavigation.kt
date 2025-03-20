package com.example.online_groceries_app.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.example.online_groceries_app.presentation.DetailScreen
import com.example.online_groceries_app.presentation.HomeScreen
import com.example.online_groceries_app.presentation.OnboardingPage
import com.example.online_groceries_app.presentation.SignInScreen
import com.example.online_groceries_app.presentation.SignUpScreen
import com.example.online_groceries_app.presentation.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("signup") { SignUpScreen() }
        composable("sigin") { SignInScreen() }
        composable("splash") { SplashScreen() }
        composable("onBoarding") { OnboardingPage() }
        composable(
            route = "detail/{cardId}/{title}/{desc}/{amount}/{imageResId}/{total}/{productDetail}",
            arguments = listOf(
                navArgument("cardId") { type = NavType.IntType },
                navArgument("title") { type = NavType.StringType },
                navArgument("desc") { type = NavType.StringType },
                navArgument("amount") { type = NavType.FloatType },
                navArgument("imageResId") { type = NavType.IntType },
                navArgument("total") { type = NavType.IntType },
                navArgument("productDetail") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            DetailScreen(
                cardId = backStackEntry.arguments?.getInt("cardId") ?: 0,
                title = backStackEntry.arguments?.getString("title") ?: "",
                desc = backStackEntry.arguments?.getString("desc") ?: "",
                amount = backStackEntry.arguments?.getFloat("amount")?.toDouble() ?: 0.0,
                imageResId = backStackEntry.arguments?.getInt("imageResId") ?: 0,
                total = backStackEntry.arguments?.getInt("total") ?: 0,
                productDetail = backStackEntry.arguments?.getString("productDetail") ?: "",
                navHostController = navController
            )
        }
    }
}
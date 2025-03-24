package com.example.online_groceries_app.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.online_groceries_app.presentation.DetailScreen
import com.example.online_groceries_app.presentation.ExploreDetailScreen
import com.example.online_groceries_app.presentation.ExploreScreen
import com.example.online_groceries_app.presentation.HomeScreen
import com.example.online_groceries_app.presentation.OnboardingPage
import com.example.online_groceries_app.presentation.SignInScreen
import com.example.online_groceries_app.presentation.SignUpScreen
import com.example.online_groceries_app.presentation.SplashScreen
import com.example.online_groceries_app.presentation.data.CardData
import com.example.online_groceries_app.presentation.data.ExploreData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URLDecoder

@Composable
fun AppNavigation(navController: NavHostController) {
    val gson = Gson()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("signup") { SignUpScreen() }
        composable("sigin") { SignInScreen() }
        composable("splash") { SplashScreen() }
        composable("onBoarding") { OnboardingPage() }
        composable("cardDetail/{cardData}") { backStackEntry ->
            val json = backStackEntry.arguments?.getString("cardData")
            val data = Gson().fromJson(json, CardData::class.java)

            if (data != null) {
                DetailScreen(cardData = data, navHostController = navController)
            } else {
                navController.popBackStack()
            }
        }
        composable("explore") { ExploreScreen(navController = navController) }
        composable("exploreDetail/{exploreData}") { backStackEntry ->
            val json = backStackEntry.arguments?.getString("exploreData")
            val data = Gson().fromJson(json, ExploreData::class.java)

            if (data != null) {
                ExploreDetailScreen(exploreData = data, navHostController = navController)
            } else {
                navController.popBackStack()
            }
        }
    }
}
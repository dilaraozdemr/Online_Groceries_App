package com.example.online_groceries_app.presentation.components.bottomBar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.chrisbanes.haze.HazeState

@Composable
fun BottomBarNav(navController: NavController) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val hazeState = remember { HazeState() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(
                Color.White,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
            .border(
                width = Dp.Hairline,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color.White,
                    ),
                ),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        BottomBarTabsWidget(
            tabs,
            selectedTab = selectedTabIndex,
            onTabSelected = {
                selectedTabIndex = tabs.indexOf(it)
                navController.navigate(it.route)
            }
        )

        val animatedSelectedTabIndex by animateFloatAsState(
            targetValue = selectedTabIndex.toFloat(),
            animationSpec = spring(stiffness = Spring.StiffnessLow)
        )

        val animatedColor by animateColorAsState(
            targetValue = tabs[selectedTabIndex].color,
            animationSpec = spring(stiffness = Spring.StiffnessLow)
        )
    }
}
package com.example.online_groceries_app.presentation.components.bottomBar

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.online_groceries_app.R

@SuppressLint("UnrememberedMutableInteractionSource")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBarTabsWidget(
    tabs: List<BottomBarTab>,
    selectedTab: Int,
    onTabSelected: (BottomBarTab) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        for (tab in tabs) {
            val isSelected = selectedTab == tabs.indexOf(tab)

            val color by animateColorAsState(
                targetValue = if (isSelected) colorResource(id = R.color.splash_background_green) else Color.Black,
                animationSpec = spring(stiffness = Spring.StiffnessLow)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .combinedClickable(
                        interactionSource = MutableInteractionSource(),
                        indication = ripple(
                            bounded = false,
                            radius = 24.dp,
                            color = colorResource(id = R.color.splash_background_green)
                        ),
                        onClick = { onTabSelected(tab) }
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Icon(imageVector = tab.icon, contentDescription = "tab ${tab.title}", tint = color)
                Text(text = tab.title, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = color)
            }
        }
    }
}
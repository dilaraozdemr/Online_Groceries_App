package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.online_groceries_app.R
import com.example.online_groceries_app.presentation.components.ButtonWidget

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun LogInScreen(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.number_back), contentDescription = "back",
                contentScale = ContentScale.Crop
            )
            Image(
                modifier = Modifier
                    .padding(top = 70.dp)
                    .width(47.84.dp)
                    .height(55.64.dp)
                    .align(Alignment.TopCenter),
                painter = painterResource(id = R.drawable.color_icon), contentDescription = "icon"
            )
        }
        Column(
            modifier = Modifier.padding(top = 200.dp, start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Loging", style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 29.sp
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.login_desc), style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 15.sp,
                    color = colorResource(id = R.color.grey)
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            Column {
                OutlinedTextField(
                    value = email,
                    onValueChange = { newValue ->
                        email = newValue
                    },
                    label = { Text(text = "Email") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .height(1.dp)
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column {
                OutlinedTextField(
                    value = password, onValueChange = { newValue ->
                        password = newValue

                    },
                    label = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.password_unvisibility),
                            contentDescription = "visibility"
                        )
                        IconButton(onClick = { visibility = !visibility }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_unvisibility),
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    }
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .height(1.dp)
                        .fillMaxWidth()
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(20.dp)
                        .clickable { },
                    textAlign = TextAlign.End,
                    text = "Forgot Password", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400
                    )
                )
                ButtonWidget(text = "Log In", onClick = {})
                Spacer(modifier = Modifier.height(30.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        textAlign = TextAlign.End,
                        text = "Don't have an account?", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                    Text(
                        modifier = Modifier.clickable { },
                        textAlign = TextAlign.End,
                        text = "Signup", style = TextStyle(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.splash_background_green),
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }

        }
    }
}
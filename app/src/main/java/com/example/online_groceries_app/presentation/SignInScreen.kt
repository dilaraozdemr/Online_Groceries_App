package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.online_groceries_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    var mobileNumber by remember { mutableStateOf("") }
    Scaffold {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.signin), contentDescription = "sign in",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(horizontal =24.53.dp )
            ) {
                Text(
                    text = stringResource(id = R.string.signin_nectar),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 29.sp,
                        letterSpacing = 0.sp
                    )
                )
                Spacer(modifier = Modifier.height(31.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.flag),
                        contentDescription = "Flag",
                        modifier = Modifier
                            .size(45.dp)
                            .padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "+880", style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 29.sp,
                            letterSpacing = 0.sp
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.light_grey),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .height(1.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.sign_in_or), style = TextStyle(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.grey)
                    )
                )
                Spacer(modifier = Modifier.height(37.8.dp))
                Box (
                    modifier= Modifier
                        .fillMaxWidth()
                        .background(
                            shape = RoundedCornerShape(19.dp),
                            color = colorResource(id = R.color.google_button_blue)
                        ),
                ){
                    Row(
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .height(24.06.dp)
                                .width(22.95.dp),
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "google")
                        Text(text = "Continue with Google", style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 18.sp
                        ))
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier= Modifier
                        .fillMaxWidth()
                        .background(
                            shape = RoundedCornerShape(19.dp),
                            color = colorResource(id = R.color.facebook_button_blue)
                        ),
                ){
                    Row(
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .height(24.06.dp)
                                .width(11.71.dp),
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "google")
                        Text(text = "Continue with Facebook", style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 18.sp
                        ))
                    }

                }
            }
        }
    }
}
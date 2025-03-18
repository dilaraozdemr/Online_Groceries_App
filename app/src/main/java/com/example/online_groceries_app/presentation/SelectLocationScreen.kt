package com.example.online_groceries_app.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
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
import com.example.online_groceries_app.presentation.components.ButtonWidget

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun SelectLocationScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val locations = arrayOf("Zonguldak", "Çankırı", "Ankara", "Samsun", "Trabzon")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(locations[0]) }

    val areas = arrayOf("Zonguldak", "Çankırı", "Ankara", "Samsun", "Trabzon")
    var expandedTwo by remember { mutableStateOf(false) }
    var selectedTextArea by remember { mutableStateOf("Types of your area") }

    Scaffold {
        Box {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.number_back),
                contentDescription = "back",
                contentScale = ContentScale.Crop
            )
            Column {
                Icon(
                    modifier = Modifier.padding(25.dp),
                    imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "back"
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(45.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "location",
                        modifier = Modifier
                            .width(224.69.dp)
                            .height(119.8.dp)
                    )
                    Spacer(modifier = Modifier.height(40.15.dp))
                    Text(
                        text = "Select your location", style = TextStyle(
                            fontSize = 26.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 29.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.select_location_desc),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            lineHeight = 15.sp,
                            color = colorResource(id = R.color.grey)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(90.dp))
                Column{
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 60.dp)
                    ) {
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {
                                expanded = !expanded
                            },
                        ) {
                            OutlinedTextField(
                                value = selectedText,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Your Zone") },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                                modifier = Modifier
                                    .menuAnchor()
                                    .background(Color.Transparent, shape = RoundedCornerShape(8.dp)),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                )
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                            ) {
                                locations.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item) },
                                        onClick = {
                                            selectedText = item
                                            expanded = false
                                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Box(modifier = Modifier
                        .padding(horizontal = 60.dp)
                        .height(1.dp)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(0.dp)
                        )
                        .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 60.dp)
                    ) {
                        ExposedDropdownMenuBox(
                            expanded = expandedTwo,
                            onExpandedChange = {
                                expandedTwo = !expandedTwo
                            },
                        ) {
                            OutlinedTextField(
                                value = selectedTextArea,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Your Area") },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedTwo) },
                                modifier = Modifier
                                    .menuAnchor()
                                    .background(Color.Transparent, shape = RoundedCornerShape(8.dp)),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                )
                            )
                            ExposedDropdownMenu(
                                expanded = expandedTwo,
                                onDismissRequest = { expandedTwo = false },
                            ) {
                                locations.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item) },
                                        onClick = {
                                            selectedTextArea = item
                                            expandedTwo = false
                                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Box(modifier = Modifier
                        .padding(horizontal = 60.dp)
                        .height(1.dp)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(0.dp)
                        )
                        .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                ButtonWidget(text = "Submit")
            }
        }
    }
}
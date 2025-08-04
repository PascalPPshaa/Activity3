package com.example.activity2

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun LoginScreenAwal() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Ini FloatingActionButton!")
                    }
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh")
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Login",
                style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
                color = Color.Black
            )
            Text(
                text = "Ini adalah halaman login",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = "Logo Universitas",
                modifier = Modifier.size(300.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text("Nama", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.Red)
            Text("Pascal Pahlevi Pasha", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Blue)
            Text("20190140105", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                shape = CircleShape,
                modifier = Modifier
                    .size(350.dp)
                    .border(4.dp, Color.White, CircleShape),
                tonalElevation = 6.dp
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "Foto Profil",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    alignment = Alignment.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            var username by remember { mutableStateOf("") }
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            var password by remember { mutableStateOf("") }
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    coroutineScope.launch {
                        if (username.isBlank()) {
                            snackbarHostState.showSnackbar("Username tidak boleh kosong")
                        } else {
                            snackbarHostState.showSnackbar("Login berhasil!")
                        }
                    }
                }) {
                    Text("Login")
                }

                OutlinedButton(onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Login dibatalkan.")
                    }
                }) {
                    Text("Batal")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Column {
                    Text("Row1_Column1")
                    Text("Row1_Column2")
                    Text("Row1_Column3")
                }
                Column {
                    Text("Row2_Column1")
                    Text("Row2_Column2")
                    Text("Row2_Column3")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text("Column1_Row1")
                        Text("Column1_Row2")
                        Text("Column1_Row3")
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text("Column2_Row1")
                        Text("Column2_Row2")
                        Text("Column2_Row3")
                    }
                }
            }
        }
    }
}

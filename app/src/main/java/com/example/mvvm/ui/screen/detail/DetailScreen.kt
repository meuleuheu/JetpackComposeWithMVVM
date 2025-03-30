package com.example.mvvm.ui.screen.detail

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, hiltViewModel: DetailViewModel) {
    Button(onClick = { navController.popBackStack() }) {
        Text(text = "Back")
    }
}
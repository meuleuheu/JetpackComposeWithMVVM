package com.example.mvvm.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.example.mvvm.Screen

@Composable
fun HomeScreen(navController: NavHostController, hiltViewModel: HomeViewModel) {
    val uiState = hiltViewModel.uiState.collectAsState()    // chuyen flow thanh state

    Column {
        ElevatedButton(onClick = { navController.navigate(Screen.Detail.route) }) {
            Text(text = "Go to Detail.")
        }
        Text(text = uiState.value.test)
        ElevatedButton(onClick = { hiltViewModel.setUiState("new state") }) {
            Text(text = "Update state")
        }
    }
}
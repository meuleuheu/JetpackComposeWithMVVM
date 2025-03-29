package com.example.mvvm

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.ui.screen.detail.DetailScreen
import com.example.mvvm.ui.screen.home.HomeScreen

sealed class Screen(val route: String) {    // or enum
    object Home: Screen("home")
    object Detail: Screen("detail")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController, hiltViewModel())
        }
        composable(route = Screen.Detail.route) {
            DetailScreen(navController, hiltViewModel())
        }
    }
}
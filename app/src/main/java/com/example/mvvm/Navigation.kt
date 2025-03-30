package com.example.mvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.ui.screen.detail.DetailScreen
import com.example.mvvm.ui.screen.home.HomeScreen
import com.example.mvvm.ui.screen.home.HomeViewModel

sealed class Screen(val route: String) {    // or enum
    object Home: Screen("home")
    object Detail: Screen("detail")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    //val viewModel = hiltViewModel<MainViewModel>()
    // viewModel khai bao ngoai navHost la viewModel tong

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController, hiltViewModel())
        }
        composable(route = Screen.Detail.route) {
            // sd view model cua parent ben trong Detail
            // tac dong them sua vao view model cua Home
            val parentEntry = remember(it) {
                navController.getBackStackEntry(Screen.Home.route)
            }
            val homeViewModel = hiltViewModel<HomeViewModel>(parentEntry)
            DetailScreen(navController, hiltViewModel())
        }
    }
}
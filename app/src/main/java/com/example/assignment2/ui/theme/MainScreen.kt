package com.example.assignment2.ui.theme

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


enum class AssignmentScreen( ){
    Screen1,
    Screen2,
    Screen3
}



@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = AssignmentScreen.Screen1.name) {
        composable(route = AssignmentScreen.Screen1.name) { 
            Screen1(
                onTwoButtonClicked = { navController.navigate(AssignmentScreen.Screen2.name) },
                onThreeButtonClicked = { navController.navigate(AssignmentScreen.Screen3.name) }
            )
        }
        composable(route = AssignmentScreen.Screen2.name) { 
            Screen2(
                onOneButtonClicked = { navController.navigate(AssignmentScreen.Screen1.name)},
                onThreeButtonClicked = {navController.navigate(AssignmentScreen.Screen3.name)}
            )
        }
        composable(route = AssignmentScreen.Screen3.name) {
            Screen3(
                onTwoButtonClicked = {navController.navigate(AssignmentScreen.Screen2.name)},
                onOneButtonClicked = {navController.navigate(AssignmentScreen.Screen1.name)}
            )

        }
    }
}

package com.sozge.animalquest.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sozge.animalquest.ui.userInputViewModel

@Composable

fun AnimalQuestNavigationGraph(userInputViewModel: userInputViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "user_input_screen") {
        composable("user_input_screen") {
            userInputScreen(userInputViewModel, navController)
        }
        composable(
            "welcomeScreen/{animal}",
            arguments = listOf(navArgument("animal") { type = NavType.StringType })
        ) { backStackEntry ->
            val animal = backStackEntry.arguments?.getString("animal") ?: ""
            welcomeScreen(navController = navController, selectedAnimal = animal, userInputViewModel= userInputViewModel)
        }
    }
}
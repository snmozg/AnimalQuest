package com.sozge.animalquest.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sozge.animalquest.ui.userInputViewModel

@Composable

fun AnimalQuestNavigationGraph(userInputViewModel: userInputViewModel = viewModel()) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
            userInputScreen(userInputViewModel)
        }

        composable(Routes.WELCOME_SCREEN) {
            welcomeScreen(navController)
        }
    }
}
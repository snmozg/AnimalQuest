package com.sozge.animalquest.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable

fun AnimalQuestNavigationGraph() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
            userInputScreen(navController)
        }

        composable(Routes.WELCOME_SCREEN) {
            welcomeScreen(navController)
        }
    }
}
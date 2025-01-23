package com.sozge.animalquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sozge.animalquest.ui.screens.Routes
import com.sozge.animalquest.ui.screens.userInputScreen
import com.sozge.animalquest.ui.screens.welcomeScreen
import com.sozge.animalquest.ui.theme.AnimalQuestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalQuestTheme {
                    AnimalQuestApp()
                }
            }
        }
    }

@Composable
fun AnimalQuestApp() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
            userInputScreen()
        }

        composable(Routes.WELCOME_SCREEN) {
            welcomeScreen()
        }
    }

}



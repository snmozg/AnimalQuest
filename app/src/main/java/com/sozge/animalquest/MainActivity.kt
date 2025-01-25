package com.sozge.animalquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.sozge.animalquest.graph.AnimalQuestNavigationGraph
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
    AnimalQuestNavigationGraph()
}



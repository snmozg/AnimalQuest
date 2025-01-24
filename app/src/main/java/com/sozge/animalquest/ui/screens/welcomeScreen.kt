package com.sozge.animalquest.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.animalquest.TextComponent
import com.sozge.animalquest.TopBar
import com.sozge.animalquest.ui.animalFacts

@Composable
fun welcomeScreen(
    navController: NavController,
    selectedAnimal: String,
    userName: String
) {
    val facts = animalFacts[selectedAnimal] ?: emptyList()
    val randomFact = facts.randomOrNull() ?: "No facts available."

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBar("Did You Know? 🐾")
            Spacer(modifier = Modifier.height(20.dp))
            TextComponent(
                textValue = "Animal: $selectedAnimal",
                textSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextComponent(
                textValue = randomFact,
                textSize = 18.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { navController.navigateUp() }) {
                TextComponent(
                    textValue = "Back to Selection",
                    textSize = 18.sp,
                    colorValue = Color.White
                )
            }
        }
    }
}
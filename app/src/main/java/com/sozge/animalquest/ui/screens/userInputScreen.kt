package com.sozge.animalquest.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.animalquest.AnimalCard
import com.sozge.animalquest.R
import com.sozge.animalquest.RandomInfoBox
import com.sozge.animalquest.TextComponent
import com.sozge.animalquest.TextFieldComponent
import com.sozge.animalquest.TopBar
import com.sozge.animalquest.ui.userInputViewModel
import java.util.jar.Attributes.Name


val infos = listOf(
    "Cats have five toes on their front paws.",
    "Elephants are the only mammals that can’t jump.",
    "A group of flamingos is called a flamboyance.",
    "Octopuses have three hearts and blue blood.",
    "The fingerprints of a koala are so indistinguishable from humans that they can confuse crime scenes."
)

@Composable
fun userInputScreen(userInputViewModel: userInputViewModel, navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 18.dp, end = 18.dp),
            verticalArrangement = Arrangement.Top
        ) {
            TopBar("Let's learn together!")

            Spacer(modifier = Modifier.height(20.dp))

            TextComponent("Pick an animal.", textSize = 24.sp)

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                val animals = listOf(
                    Pair("Cat", R.drawable.cat),
                    Pair("Dog", R.drawable.dog),
                    Pair("Koala", R.drawable.koala)
                )
                val selectedAnimal = userInputViewModel.uiState.value.animalSelected

                items(animals) { animal ->
                    AnimalCard(
                        navController = navController,
                        image = animal.second,
                        selected = selectedAnimal == animal.first,
                        animalName = animal.first,
                        onAnimalSelected = { userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it)) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            TextComponent(
                textValue = "Did you know?",
                textSize = 20.sp
            )

            Spacer(modifier =Modifier.size(10.dp))

            val infos = listOf(
                "Cats have five toes on their front paws.",
                "Elephants are the only mammals that can’t jump.",
                "A group of flamingos is called a flamboyance.",
                "Octopuses have three hearts and blue blood.",
                "The fingerprints of a koala are so indistinguishable from humans that they can confuse crime scenes."
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,

                ) {
                RandomInfoBox(infos = infos)
                Spacer(modifier =Modifier.size(10.dp))

                Button(
                    modifier = Modifier.fillMaxWidth().padding(6.dp),
                    onClick = {
                        val selectedAnimal = userInputViewModel.uiState.value.animalSelected
                        if (selectedAnimal.isNotEmpty()) {
                            navController.navigate("welcomeScreen/$selectedAnimal")
                        }
                    },
                    enabled = userInputViewModel.uiState.value.animalSelected.isNotEmpty()
                ) {
                    Text(text = "Go to details")
                }


            }





        }
    }
}


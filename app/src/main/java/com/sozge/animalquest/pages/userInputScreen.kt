package com.sozge.animalquest.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.animalquest.R
import com.sozge.animalquest.components.AnimalCard
import com.sozge.animalquest.components.CustomButton
import com.sozge.animalquest.components.CustomText
import com.sozge.animalquest.components.RandomBox
import com.sozge.animalquest.datas.UserDataUiEvents
import com.sozge.animalquest.lists.infos
import com.sozge.animalquest.viewmodels.userInputViewModel

@Composable
fun userInputScreen(userInputViewModel: userInputViewModel, navController: NavController) {
    val infos = infos

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            CustomText(
                "Let's learn together!",
                36.sp,
                MaterialTheme.colorScheme.primary,
                TextAlign.Center,
                FontWeight.Bold
            )
            CustomText(
                textValue = "\n" +
                        "Choose your favorite animal, click the button and learn about it.",
                textSize = 16.sp,
                colorValue = Color.Gray,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            CustomText(
                "Pick an animal",
                textSize = 24.sp,
                colorValue = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val animals = listOf(
                    Pair("Cat", R.drawable.newcat),
                    Pair("Dog", R.drawable.newdog),
                    Pair("Elephant", R.drawable.newelephant),
                    Pair("Giraffe", R.drawable.newgiraffe),
                    Pair("Lamp", R.drawable.newlamb),
                    Pair("Lion", R.drawable.newlion),
                    Pair("Owl", R.drawable.newowl),
                    Pair("Parrot", R.drawable.newparrot),
                    Pair("Wolf", R.drawable.newwolf),

                    /*
                    Pair("Koala", R.drawable.koala),
                    Pair("Fish", R.drawable.fish),
                    Pair("Hamster", R.drawable.hamster),
                    Pair("Cow", R.drawable.cow),
                    Pair("Monkey", R.drawable.monkey),
                    Pair("Bear", R.drawable.love),
                    Pair("Horse", R.drawable.horse),

                     */
                )
                val selectedAnimal = userInputViewModel.uiState.value.animalSelected

                items(animals) { animal ->
                    AnimalCard(
                        navController = navController,
                        image = animal.second,
                        selected = selectedAnimal == animal.first,
                        animalName = animal.first,
                        onAnimalSelected = {
                            userInputViewModel.onEvent(
                                UserDataUiEvents.AnimalSelected(
                                    it
                                )
                            )
                        },
                    )
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            CustomText(
                textValue = "Did you know?",
                textSize = 24.sp,
                colorValue = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
            RandomBox(infos = infos)
        }

        CustomButton(
            navController = navController,
            userInputViewModel = userInputViewModel,
            text = "Go to details",
            onClick = {
                val selectedAnimal = userInputViewModel.uiState.value.animalSelected
                if (selectedAnimal.isNotEmpty()) {
                    navController.navigate("welcomeScreen/$selectedAnimal")
                }
            },
            enable = userInputViewModel.uiState.value.animalSelected.isNotEmpty()
        )
    }
}
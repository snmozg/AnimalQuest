package com.sozge.animalquest.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.animalquest.AnimalCard
import com.sozge.animalquest.ButtonComponent
import com.sozge.animalquest.R
import com.sozge.animalquest.TextComponent
import com.sozge.animalquest.TextFieldComponent
import com.sozge.animalquest.TopBar
import com.sozge.animalquest.ui.userInputViewModel
import java.util.jar.Attributes.Name


@Composable
fun userInputScreen(userInputViewModel: userInputViewModel, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
                .padding(18.dp),
            verticalArrangement = Arrangement.Top
        ) {
            TopBar("Hi There! \uD83D\uDE0B")

            TextComponent(
                textValue = "Let's learn about You!",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you.",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(
                onTextChanged = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.UserNameEntered(it)
                    )
                }
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                val name = userInputViewModel.uiState.value.nameEntered

                AnimalCard(
                    navController = navController,
                    image = R.drawable.cat,
                    selected = userInputViewModel.uiState.value.animalSelected == "Cat",
                    animalName = "Cat",
                    userName = name
                )

                AnimalCard(
                    navController = navController,
                    image = R.drawable.dog,
                    selected = userInputViewModel.uiState.value.animalSelected == "Dog",
                    animalName = "Dog",
                    userName = name
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailsScreen = {
                        val selectedAnimal = userInputViewModel.uiState.value.animalSelected
                        navController.navigate("details_screen/$selectedAnimal")
                    }
                )
            }
        }
    }
}



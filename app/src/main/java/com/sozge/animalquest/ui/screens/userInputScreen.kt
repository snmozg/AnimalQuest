package com.sozge.animalquest.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.sozge.animalquest.ButtonComponent
import com.sozge.animalquest.R
import com.sozge.animalquest.RandomInfoBox
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
            TopBar("Let's learn together!")

            TextComponent(
                textValue = "Pick an animal.",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                textValue = "Choose an animal and learn something about it.",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            /*TextComponent(textValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(
                onTextChanged = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.UserNameEntered(it)
                    )
                }
            )

            Spacer(modifier = Modifier.size(20.dp))

             */

            TextComponent(textValue="Which animal?", textSize = 18.sp)

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                val name = userInputViewModel.uiState.value.nameEntered
                val animals = listOf(
                    Pair("Cat", R.drawable.cat),
                    Pair("Dog", R.drawable.dog),
                    Pair("Koala", R.drawable.koala),
                )

                items(animals) { animal ->
                    val animalName = animal.first
                    val animalImage = animal.second

                    AnimalCard(
                        navController = navController,
                        image = animalImage,
                        selected = userInputViewModel.uiState.value.animalSelected == animalName,
                        animalName = animalName,
                        userName = name
                    )
                }
            }

            Spacer(modifier = Modifier.size(60.dp))

            @Composable
            fun AnimalCardButton(
                animalName: String,
                navController: NavController
            ) {
                Button(
                    onClick = {
                        // Detay sayfasına seçilen kartın bilgisiyle yönlendirme
                        navController.navigate("details_screen/$animalName")
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Go to details of $animalName",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            
            TextComponent(
                textValue = "Did you know?",
                textSize = 20.sp
            )

            Spacer(modifier =Modifier.size(10.dp))

            val infos = listOf(
                "Did you know? Cats have five toes on their front paws.",
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
            }
        }
    }
}



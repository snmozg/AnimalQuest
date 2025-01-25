package com.sozge.animalquest.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.animalquest.R
import com.sozge.animalquest.components.CustomButton
import com.sozge.animalquest.components.CustomText
import com.sozge.animalquest.components.RandomBox
import com.sozge.animalquest.lists.animalFacts
import com.sozge.animalquest.viewmodels.userInputViewModel

@Composable
fun welcomeScreen(
    navController: NavController,
    selectedAnimal: String,
    userInputViewModel: userInputViewModel,
) {
    val facts = animalFacts[selectedAnimal] ?: emptyList()
    val randomFact = facts.randomOrNull() ?: "No facts available."

    val animalImage = when (selectedAnimal) {
        "Cat" -> R.drawable.newcat
        "Dog" -> R.drawable.newdog
        "Elephant" -> R.drawable.newelephant
        "Giraffe" -> R.drawable.newgiraffe
        "Lamp" -> R.drawable.newlamb
        "Lion" -> R.drawable.newlion
        "Owl" -> R.drawable.newowl
        "Parrot" -> R.drawable.newparrot
        "Wolf" -> R.drawable.newwolf
        else -> R.drawable.ic_launcher_foreground
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            CustomText(
                textValue = "Did You Know?",
                36.sp,
                MaterialTheme.colorScheme.primary,
                TextAlign.Center,
                FontWeight.Bold
            )

            CustomText(
                textValue = "Here is the animal you chose and some information about it.",
                textSize = 16.sp,
                colorValue = Color.Gray,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal
            )
        }

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.primary)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = animalImage),
                            contentDescription = "$selectedAnimal Image",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(10.dp),
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.Center
                        )
                        Text(
                            text = selectedAnimal,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomText(
                    textValue = "Did you know about $selectedAnimal?",
                    textSize = 24.sp,
                    colorValue = MaterialTheme.colorScheme.tertiary,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold
                )
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 10.dp, bottom = 10.dp)
                        .height(100.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.primary)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                CustomText(
                                    textValue = randomFact,
                                    textSize = 18.sp,
                                    colorValue = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                    }
                }
            }
        }

        CustomButton(
            navController = navController,
            userInputViewModel = userInputViewModel,
            text = "Back to Selection",
            onClick = {
                userInputViewModel.resetState()
                navController.navigateUp()
            },
            enable = true
        )
    }
}
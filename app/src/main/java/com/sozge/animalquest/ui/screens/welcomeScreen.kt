package com.sozge.animalquest.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.animalquest.R
import com.sozge.animalquest.TextComponent
import com.sozge.animalquest.TopBar
import com.sozge.animalquest.ui.animalFacts
import com.sozge.animalquest.ui.userInputViewModel

@Composable
fun welcomeScreen(
    navController: NavController,
    selectedAnimal: String,
    userInputViewModel: userInputViewModel,) {

    val facts = animalFacts[selectedAnimal] ?: emptyList()
    val randomFact = facts.randomOrNull() ?: "No facts available."


    val animalImage = when (selectedAnimal) {
            "Cat"->  R.drawable.cat
            "Dog"->  R.drawable.dog
            "Koala"->  R.drawable.koala
            "Fish"->  R.drawable.fish
            "Hamster"->  R.drawable.hamster
            "Cow"-> R.drawable.cow
            "Monkey"->  R.drawable.monkey
            "Bear"-> R.drawable.love
            "Horse"-> R.drawable.horse
        else -> R.drawable.hamster
    }

            Surface(
            modifier = Modifier.fillMaxSize()
            ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopBar("Did You Know? ")

            Spacer(modifier = Modifier.size(30.dp))

            TextComponent(
                textValue = "Here is the animal you chose and some information about it.",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(30.dp))


            Box(
                modifier = Modifier
                    .size(150.dp)
                    .padding(16.dp),
                    contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = animalImage),
                    contentDescription = "$selectedAnimal Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Did you know about $selectedAnimal?",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .padding(16.dp)
                            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    ) {
                        Text(
                            text = randomFact,
                            style = TextStyle(fontSize = 20.sp, color = Color.Black),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = {
                    userInputViewModel.resetState()
                    navController.navigateUp()
                },
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Text(
                    text = "Back to Selection",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}
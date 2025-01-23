package com.sozge.animalquest.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sozge.animalquest.TextComponent
import com.sozge.animalquest.TopBar


@Composable
fun userInputScreen(
    navController: NavHostController) {
    Surface(
        modifier= Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)

        ) {
            TopBar("Hi There! \uD83D\uDE0B")
            
            TextComponent(
                textValue = "Let's learn about You!" ,
                textSize = 24.sp)

            Spacer(modifier =Modifier.size(20.dp))
            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you." ,
                textSize = 18.sp)

            Spacer(modifier =Modifier.size(60.dp))

        }
    }
}


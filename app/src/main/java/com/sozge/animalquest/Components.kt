package com.sozge.animalquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
 fun TopBar(value: String) {
     Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
            )

         Spacer(modifier =Modifier.weight(1f))
         Image(
             modifier = Modifier.size(80.dp),
             painter = painterResource(id = R.drawable.koala),
             contentDescription = "app logo")
     }
 }

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue : Color = Color.Black,
    ) {
    Text(
        text = textValue,
        color = colorValue,
        fontSize = textSize
    )


}
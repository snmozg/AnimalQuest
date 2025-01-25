package com.sozge.animalquest.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.animalquest.viewmodels.userInputViewModel

@Composable
fun CustomButton(
    navController: NavController,
    userInputViewModel: userInputViewModel,
    text: String,
    onClick: () -> Unit,
    enable: Boolean
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = {
            onClick()
        },
        enabled = enable
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 24.sp
        )
    }
}
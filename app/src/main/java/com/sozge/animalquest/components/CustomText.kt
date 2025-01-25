package com.sozge.animalquest.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomText(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color,
    textAlign: TextAlign,
    fontWeight: FontWeight
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = textValue,
            color = colorValue,
            fontSize = textSize,
            textAlign = textAlign,
            fontWeight = fontWeight
        )
    }
}
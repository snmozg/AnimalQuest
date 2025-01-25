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

// TopBar -> CustomTitle
@Composable
fun CustomTitle0(
    value: String,
    fontSize: TextUnit,
    color: Color,
    textAlign: TextAlign
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = value,
            color = color,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = textAlign
        )
    }
}
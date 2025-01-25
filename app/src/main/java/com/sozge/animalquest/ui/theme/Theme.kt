package com.sozge.animalquest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = newPurple,
    secondary = newBlack,
    background = newWhite,
    tertiary = newLightPurple,
)

private val LightColorScheme = lightColorScheme(
    primary = newPurple,
    secondary = newBlack,
    background = newWhite,
    tertiary = newLightPurple,
)

@Composable
fun AnimalQuestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
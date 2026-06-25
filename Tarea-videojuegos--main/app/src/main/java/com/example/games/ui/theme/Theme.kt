package com.example.games.ui.theme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorScheme = lightColorScheme(
    primary = VerdeMe,
    secondary = VerdeOs ,
    background = AmarilloSuave,
    surface = Color.White
)

@Composable
fun AppVideojuegosTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightColorScheme, content = content)
}
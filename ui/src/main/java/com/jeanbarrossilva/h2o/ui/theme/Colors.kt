package com.jeanbarrossilva.h2o.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightPrimary = Color(0xFF2196F3)
private val LightPrimaryContainer = Color(0xFFCDEFFF)
private val LightOnPrimaryContainer = Color(0xFF227CC5)
private val LightBackground = Color.White
private val LightSurface = Color.White
private val LightSurfaceVariant = Color(0xFFF5F5F5)
private val LightOnSurfaceVariant = Color(0xFFECECEC)
private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    background = LightBackground,
    surface = LightSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant
)

private val DarkPrimary = Color(0xFF576EEE)
private val DarkPrimaryContainer = Color(0xFF3F51B5)
private val DarkOnPrimaryContainer = Color(0xFFCDEFFF)
private val DarkSurface = Color(0xFF2C2C2C)
private val DarkSurfaceVariant = Color(0xFF353535)
private val DarkOnSurfaceVariant = Color(0xFF242424)
private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    surface = DarkSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant
)

val colorScheme
    @Composable get() = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
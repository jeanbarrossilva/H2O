package com.jeanbarrossilva.h2o.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun H2OTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme,
        typography = Typography,
        content = content
    )
}
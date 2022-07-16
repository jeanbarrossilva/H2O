package com.jeanbarrossilva.h2o.ui.theme

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun H2OTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme,
        Shapes,
        Typography
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onBackground,
            content = content
        )
    }
}
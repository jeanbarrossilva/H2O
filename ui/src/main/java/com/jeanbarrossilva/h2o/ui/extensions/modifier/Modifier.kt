package com.jeanbarrossilva.h2o.ui.extensions.modifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.on(condition: Boolean, update: @Composable Modifier.() -> Modifier): Modifier {
    return composed {
        if (condition) update() else this
    }
}
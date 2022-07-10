package com.jeanbarrossilva.h2o.ui.extensions.dp

import androidx.compose.ui.unit.Dp
import kotlin.math.abs

fun abs(value: Dp): Dp {
    return with(value) {
        Dp(abs(this.value))
    }
}
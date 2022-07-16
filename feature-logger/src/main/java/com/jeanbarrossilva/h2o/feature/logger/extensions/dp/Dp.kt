package com.jeanbarrossilva.h2o.feature.logger.extensions.dp

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

fun Dp.toSize(density: Density): Size {
    val px = with(density) { toPx() }
    return Size(px, px)
}
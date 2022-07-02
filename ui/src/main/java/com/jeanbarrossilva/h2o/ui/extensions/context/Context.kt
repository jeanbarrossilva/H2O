package com.jeanbarrossilva.h2o.ui.extensions.context

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize

val Context.screenSize: DpSize
    @Composable get() {
        val (widthInPx, heightInPx) =
            with(resources.configuration) { screenWidthDp to screenHeightDp }
        val (widthInDp, heightInDp) =
            with(LocalDensity.current) { widthInPx.toDp() to heightInPx.toDp() }

        return DpSize(widthInDp, heightInDp)
    }
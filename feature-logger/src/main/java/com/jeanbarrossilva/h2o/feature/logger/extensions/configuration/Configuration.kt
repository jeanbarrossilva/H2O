package com.jeanbarrossilva.h2o.feature.logger.extensions.configuration

import android.content.res.Configuration
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

val Configuration.screenSize
    get() = DpSize(screenWidthDp.dp, screenHeightDp.dp)
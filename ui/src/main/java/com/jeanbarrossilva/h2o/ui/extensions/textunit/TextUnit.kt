package com.jeanbarrossilva.h2o.ui.extensions.textunit

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

operator fun TextUnit.plus(other: TextUnit): TextUnit {
    return value.plus(other.value).sp
}
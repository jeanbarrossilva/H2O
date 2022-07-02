package com.jeanbarrossilva.h2o.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.jeanbarrossilva.h2o.ui.R
import com.jeanbarrossilva.h2o.ui.extensions.typography.Typography

val Typography = Typography(
    FontFamily(
        Font(R.font.arvo_regular),
        Font(R.font.arvo_regular_italic, style = FontStyle.Italic),
        Font(R.font.arvo_bold, FontWeight.Bold),
        Font(R.font.arvo_bold_italic, FontWeight.Bold, FontStyle.Italic)
    )
)
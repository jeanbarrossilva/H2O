package com.jeanbarrossilva.h2o.ui.extensions.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

// For some unknown and very sinister, somber reason, Material 3's version of the Typography class
// doesn't have a parameter for setting the default font family.
fun Typography(
    defaultFontFamily: FontFamily,
    displayLarge: TextStyle = TypographyTokens.DisplayLarge,
    displayMedium: TextStyle = TypographyTokens.DisplayMedium,
    displaySmall: TextStyle = TypographyTokens.DisplaySmall,
    headlineLarge: TextStyle = TypographyTokens.HeadlineLarge,
    headlineMedium: TextStyle = TypographyTokens.HeadlineMedium,
    headlineSmall: TextStyle = TypographyTokens.HeadlineSmall,
    titleLarge: TextStyle = TypographyTokens.TitleLarge,
    titleMedium: TextStyle = TypographyTokens.TitleMedium,
    titleSmall: TextStyle = TypographyTokens.TitleSmall,
    labelLarge: TextStyle = TypographyTokens.LabelLarge,
    labelMedium: TextStyle = TypographyTokens.LabelMedium,
    labelSmall: TextStyle = TypographyTokens.LabelSmall,
    bodyLarge: TextStyle = TypographyTokens.BodyLarge,
    bodyMedium: TextStyle = TypographyTokens.BodyMedium,
    bodySmall: TextStyle = TypographyTokens.BodySmall
): Typography {
    return TextStyle(fontFamily = defaultFontFamily).let {
        Typography(
            displayLarge + it,
            displayMedium + it,
            displaySmall + it,
            headlineLarge + it,
            headlineMedium + it,
            headlineSmall + it,
            titleLarge + it,
            titleMedium + it,
            titleSmall + it,
            bodyLarge + it,
            bodyMedium + it,
            bodySmall + it,
            labelLarge + it,
            labelMedium + it,
            labelSmall + it
        )
    }
}
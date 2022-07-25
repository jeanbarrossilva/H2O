package com.jeanbarrossilva.h2o.ui.provider

import android.content.res.Configuration
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.environment.ContentAlpha
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
fun ProvideMediumColoredTextStyle(content: @Composable () -> Unit) {
    ProvideTextStyle(
        LocalTextStyle.current.copy(color = LocalContentColor.current.copy(ContentAlpha.MEDIUM)),
        content
    )
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun ProvideMediumColoredTextStylePreview() {
    H2OTheme {
        Background(isFilling = false) {
            ProvideMediumColoredTextStyle {
                Text("Hello, world!")
            }
        }
    }
}
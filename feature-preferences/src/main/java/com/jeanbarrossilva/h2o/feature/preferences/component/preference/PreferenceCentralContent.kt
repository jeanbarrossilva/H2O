package com.jeanbarrossilva.h2o.feature.preferences.component.preference

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.provider.ProvideMediumColoredTextStyle
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun PreferenceCentralContent(
    summary: @Composable (() -> Unit)?,
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit
) {
    Column(modifier) {
        ProvideTextStyle(
            LocalTextStyle.current.copy(fontWeight = FontWeight.Bold),
            content = title
        )

        ProvideMediumColoredTextStyle {
            summary?.invoke()
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PreferenceCentralContentPreview() {
    H2OTheme {
        Background(isFilling = false) {
            PreferenceCentralContent(summary = { Text("Summary") }) {
                Text("Title")
            }
        }
    }
}
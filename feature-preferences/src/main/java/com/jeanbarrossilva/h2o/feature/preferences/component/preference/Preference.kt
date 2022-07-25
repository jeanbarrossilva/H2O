package com.jeanbarrossilva.h2o.feature.preferences.component.preference

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.feature.preferences.component.preference.Preference.Spacing
import com.jeanbarrossilva.h2o.ui.provider.ProvideMediumColoredTextStyle
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import com.jeanbarrossilva.h2o.ui.environment.Spacing as _Spacing

internal object Preference {
    val Spacing = _Spacing.xxxl
}

@Composable
internal fun Preference(
    modifier: Modifier = Modifier,
    leading: @Composable (BoxScope.() -> Unit)? = null,
    summary: @Composable (() -> Unit)? = null,
    trailing: @Composable (BoxScope.() -> Unit)? = null,
    title: @Composable () -> Unit
) {
    Surface(modifier) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(Spacing),
            Arrangement.spacedBy(Spacing),
            Alignment.CenterVertically
        ) {
            PreferenceLateralContent(
                isLeading = true,
                content = leading
            )

            PreferenceCentralContent(
                summary,
                title = title
            )

            Box(
                Modifier.fillMaxWidth(),
                Alignment.CenterEnd
            ) {
                PreferenceLateralContent(isLeading = false) {
                    ProvideMediumColoredTextStyle {
                        trailing?.invoke(this)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PreferencePreview() {
    H2OTheme {
        Preference(
            leading = {
                Switch(
                    checked = true,
                    onCheckedChange = { }
                )
            },
            summary = { Text("Summary") },
            trailing = {
                Icon(
                    Icons.Default.Done,
                    contentDescription = null
                )
            }
        ) {
            Text("Title")
        }
    }
}
package com.jeanbarrossilva.h2o.feature.preferences.component.preference

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.component.Divider
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun PreferenceLateralContent(
    isLeading: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable (BoxScope.() -> Unit)?
) {
    content?.let {
        Row(
            modifier,
            Arrangement.spacedBy(Preference.Spacing),
            Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                content = content
            )

            if (isLeading) {
                Divider(
                    Modifier
                        .width(1.dp)
                        .height(32.dp)
                )
            }
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PreferenceLateralContentPreview() {
    H2OTheme {
        Background(isFilling = false) {
            PreferenceLateralContent(isLeading = true) {
                Switch(
                    checked = true,
                    onCheckedChange = { }
                )
            }
        }
    }
}
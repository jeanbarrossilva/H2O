package com.jeanbarrossilva.h2o.ui.component.section

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.component.section.SectionHeadlinedContent.Alignment
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

internal object SectionHeadlinedContent {
    val Alignment = androidx.compose.ui.Alignment.Center
}

@Composable
internal fun SectionHeadlinedContent(
    headline: @Composable () -> Unit,
    alignment: Alignment,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Column(
        modifier.padding(Spacing.xxxxxxl),
        Arrangement.spacedBy(Spacing.l)
    ) {
        headline()

        Box(
            Modifier.fillMaxWidth(),
            alignment,
            content = content
        )
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SectionHeadlinedContentPreview() {
    H2OTheme {
        Background(isFilling = false) {
            SectionHeadlinedContent(
                headline = {
                    SectionHeadline(
                        title = { Text("Title") },
                        subtitle = { Text("Subtitle") }
                    )
                },
                Alignment
            ) {
                Text("Content")
            }
        }
    }
}
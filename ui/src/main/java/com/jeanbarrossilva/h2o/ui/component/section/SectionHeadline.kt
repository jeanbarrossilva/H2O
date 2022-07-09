package com.jeanbarrossilva.h2o.ui.component.section

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.environment.ContentAlpha
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun SectionHeadline(
    title: @Composable (() -> Unit)?,
    subtitle: @Composable (() -> Unit)?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier,
        Arrangement.spacedBy(Spacing.m)
    ) {
        ProvideTextStyle(
            LocalTextStyle.current + MaterialTheme.typography.headlineSmall
        ) {
            title?.invoke()
        }

        ProvideTextStyle(
            LocalTextStyle.current + MaterialTheme.typography.titleMedium.copy(
                LocalContentColor.current.copy(ContentAlpha.MEDIUM)
            )
        ) {
            subtitle?.invoke()
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SectionHeadlinePreview() {
    H2OTheme {
        Background(isFilling = false) {
            SectionHeadline(
                title = { Text("Title") },
                subtitle = { Text("Subtitle") }
            )
        }
    }
}
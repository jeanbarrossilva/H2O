package com.jeanbarrossilva.h2o.ui.component.section

import android.content.res.Configuration
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
import com.jeanbarrossilva.h2o.ui.component.Divider
import com.jeanbarrossilva.h2o.ui.component.section.Section.Alignment
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

object Section {
    val Alignment = SectionHeadlinedContent.Alignment
}

@Composable
fun Section(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment,
    isLastOne: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Section(
        modifier,
        title = null,
        subtitle = null,
        alignment,
        isLastOne,
        content
    )
}

@Composable
fun Section(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: @Composable (() -> Unit)? = null,
    alignment: Alignment = Alignment,
    isLastOne: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Section(
        modifier,
        title,
        subtitle,
        alignment,
        isLastOne,
        content
    )
}

@Composable
private fun Section(
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)?,
    subtitle: @Composable (() -> Unit)?,
    alignment: Alignment,
    isLastOne: Boolean,
    content: @Composable BoxScope.() -> Unit
) {
    Column(modifier) {
        SectionHeadlinedContent(
            headline = {
                SectionHeadline(
                    title,
                    subtitle
                )
            },
            alignment
        ) {
            Box(
                Modifier.fillMaxWidth(),
                alignment,
                content = content
            )
        }

        if (!isLastOne) {
            Box(Modifier.padding(horizontal = Spacing.xxxl)) {
                Divider()
            }
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SectionPreview() {
    H2OTheme {
        Background(isFilling = false) {
            Section({ Text("Title") }) {
                Text("Content")
            }
        }
    }
}
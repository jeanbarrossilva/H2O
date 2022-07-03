package com.jeanbarrossilva.h2o.ui.today.component.historysheet

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.model.intake.IntakeLog
import com.jeanbarrossilva.h2o.ui.component.sheet.Sheet
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import com.jeanbarrossilva.h2o.ui.today.component.IntakeCard

@Composable
internal fun HistorySheetContent(
    logs: List<IntakeLog>,
    modifier: Modifier = Modifier
) {
    val spacing = Spacing.m

    Sheet(modifier) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(spacing)) {
            items(logs) { log ->
                IntakeCard(
                    log.intake,
                    onClick = { }
                )

                if (logs.last() == log) {
                    Spacer(
                        Modifier
                            .fillMaxWidth()
                            .height(spacing)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun HistorySheetContentPreview() {
    H2OTheme {
        HistorySheetContent(IntakeLog.samples)
    }
}
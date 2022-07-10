package com.jeanbarrossilva.h2o.feature.history

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.feature.history.component.IntakeCard
import com.jeanbarrossilva.h2o.model.intake.IntakeLog
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.component.section.Section
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun History(
    viewModel: HistoryViewModel,
    modifier: Modifier = Modifier
) {
    var logs by remember { mutableStateOf(emptyList<IntakeLog>()) }

    LaunchedEffect(Unit) {
        logs = viewModel.getLogs()
    }

    History(
        logs,
        modifier
    )
}

@Composable
private fun History(
    logs: List<IntakeLog>,
    modifier: Modifier = Modifier
) {
    val spacing = Spacing.m

    Background(modifier) {
        Section(
            title = { Text(stringResource(R.string.history)) },
            isLastOne = true
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(spacing),
                userScrollEnabled = false
            ) {
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
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun HistoryPreview() {
    H2OTheme {
        History(IntakeLog.samples)
    }
}
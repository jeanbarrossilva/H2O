package com.jeanbarrossilva.h2o.feature.today

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.jeanbarrossilva.h2o.model.intake.IntakeLog
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.component.FloatingActionButton
import com.jeanbarrossilva.h2o.ui.component.section.Section
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import com.jeanbarrossilva.h2o.feature.today.component.FrequencyChart
import com.jeanbarrossilva.h2o.feature.today.component.IntakeStatusChart
import com.jeanbarrossilva.h2o.feature.today.component.options.Options
import com.jeanbarrossilva.h2o.feature.today.R

@Composable
internal fun Today(
    activity: FragmentActivity?,
    viewModel: TodayViewModel,
    boundary: TodayBoundary,
    modifier: Modifier = Modifier
) {
    var status by remember { mutableStateOf(IntakeStatus.zero) }
    var logs by remember { mutableStateOf(emptyList<IntakeLog>()) }

    LaunchedEffect(Unit) {
        status = viewModel.getIntakeStatus()
        logs = viewModel.getLogs()
    }

    Today(
        status,
        logs,
        onIntakeLogRequest = boundary::navigateToIntakeLogger,
        onHistoryRequest = { boundary.navigateToHistory(activity) },
        modifier
    )
}

@Composable
private fun Today(
    status: IntakeStatus,
    logs: List<IntakeLog>,
    onIntakeLogRequest: () -> Unit,
    onHistoryRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Background(modifier) {
        Column(
            Modifier
                .verticalScroll(scrollState)
                .padding(bottom = FloatingActionButton.Size + FloatingActionButton.Margin * 2)
        ) {
            Section(
                alignment = Alignment.Center
            ) {
                IntakeStatusChart(status)
            }

            Section(
                title = { Text(stringResource(R.string.today_frequency)) },
                subtitle = { Text(stringResource(R.string.today_frequency_subtitle)) },
                isLastOne = true
            ) {
                FrequencyChart(logs)
            }
        }

        Options(
            onIntakeLogRequest,
            onHistoryRequest,
            Modifier
                .fillMaxWidth()
                .padding(bottom = FloatingActionButton.Margin)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun TodayPreview() {
    H2OTheme {
        Today(
            IntakeStatus.sample,
            IntakeLog.samples,
            onIntakeLogRequest = { },
            onHistoryRequest = { }
        )
    }
}
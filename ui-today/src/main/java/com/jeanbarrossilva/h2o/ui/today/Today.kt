package com.jeanbarrossilva.h2o.ui.today

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.model.intake.IntakeLog
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.component.FloatingActionButton
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import com.jeanbarrossilva.h2o.ui.today.component.IntakeChart
import com.jeanbarrossilva.h2o.ui.today.component.historysheet.HistorySheet
import com.jeanbarrossilva.h2o.ui.today.component.options.Options
import kotlinx.coroutines.launch

@Composable
internal fun Today(
    viewModel: TodayViewModel,
    onIntakeLogRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    var intake by remember { mutableStateOf(Intake.zero) }
    var logs by remember { mutableStateOf(emptyList<IntakeLog>()) }
    var intakeGoalInMilliliters by remember { mutableStateOf(0L) }

    LaunchedEffect(Unit) {
        intake = viewModel.getIntake()
        logs = viewModel.getLogs()
        intakeGoalInMilliliters = viewModel.getIntakeGoal()
    }

    Today(
        intake,
        logs,
        intakeGoalInMilliliters,
        onIntakeLogRequest,
        modifier
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun Today(
    intake: Intake,
    logs: List<IntakeLog>,
    intakeGoalInMilliliters: Long,
    onIntakeLogRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    var sheetOffset by remember { mutableStateOf(0.dp) }
    var chartBoxBottomBound by remember { mutableStateOf(0.dp) }
    val sheetRelatedOptionsY = sheetOffset - FloatingActionButton.Size - FloatingActionButton.Margin
    val areOptionsAtChartBoxBottomBoundLimit = sheetRelatedOptionsY <= chartBoxBottomBound
    val optionsY =
        if (areOptionsAtChartBoxBottomBoundLimit) chartBoxBottomBound else sheetRelatedOptionsY
    val optionsYInPx = with(density) { optionsY.toPx() }
    var isHistoryShown by remember { mutableStateOf(false) }

    DisposableEffect(sheetState.isVisible) {
        isHistoryShown = sheetState.isVisible
        onDispose { }
    }

    Background(modifier) {
        HistorySheet(
            sheetState,
            logs,
            onOffsetChange = { sheetOffset = it }
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(Spacing.xxxxxxl)
                    .onGloballyPositioned { coordinates ->
                        chartBoxBottomBound = with(density) {
                            coordinates.boundsInWindow().bottom.toDp()
                        }
                    },
                Alignment.Center
            ) {
                IntakeChart(
                    intake,
                    intakeGoalInMilliliters
                )
            }

            Options(
                isHistoryOptionShown = !isHistoryShown,
                onIntakeLogRequest,
                onHistoryRequest = {
                    coroutineScope.launch {
                        sheetState.animateTo(ModalBottomSheetValue.HalfExpanded)
                    }
                },
                Modifier
                    .fillMaxWidth()
                    .graphicsLayer(translationY = optionsYInPx)
            )
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun TodayPreview() {
    H2OTheme {
        Today(
            Intake.sample,
            IntakeLog.samples,
            intakeGoalInMilliliters = 4_500,
            onIntakeLogRequest = { }
        )
    }
}
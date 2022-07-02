package com.jeanbarrossilva.h2o.ui.today.component.historysheet

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.jeanbarrossilva.h2o.logger.intake.IntakeLog
import com.jeanbarrossilva.h2o.ui.component.sheet.Sheet

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun HistorySheet(
    state: ModalBottomSheetState,
    logs: List<IntakeLog>,
    onOffsetChange: (offset: Dp) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val backgroundColor = MaterialTheme.colorScheme.surface
    val contentColor = contentColorFor(backgroundColor)

    HistorySheetOffsetDisposableEffect(
        state,
        onOffsetChange
    )

    ModalBottomSheetLayout(
        sheetContent = { HistorySheetContent(logs) },
        modifier,
        state,
        Sheet.shape,
        sheetBackgroundColor = backgroundColor,
        sheetContentColor = contentColor,
        scrimColor = Color.Transparent,
        content = content
    )
}
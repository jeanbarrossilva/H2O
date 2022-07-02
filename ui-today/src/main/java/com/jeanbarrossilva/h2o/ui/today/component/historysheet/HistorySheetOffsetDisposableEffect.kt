package com.jeanbarrossilva.h2o.ui.today.component.historysheet

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun HistorySheetOffsetDisposableEffect(
    state: ModalBottomSheetState,
    onOffsetChange: (offset: Dp) -> Unit
) {
    val density = LocalDensity.current
    val offset by state.offset
    val offsetInDp = with(density) { offset.toDp() }

    DisposableEffect(offsetInDp) {
        onOffsetChange(offsetInDp)
        onDispose { }
    }
}
package com.jeanbarrossilva.h2o.feature.today.extensions.delayable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import com.jeanbarrossilva.h2o.feature.today.delayable.DelayFrequency
import com.jeanbarrossilva.h2o.feature.today.delayable.DelayMode
import com.jeanbarrossilva.h2o.feature.today.delayable.Delayable
import kotlinx.coroutines.delay

@Composable
internal fun Delayable.getActivenessState(): State<Boolean> {
    return getActivenessFlow().collectAsState(LocalView.current.isInEditMode)
}

@Composable
internal fun previewDelayable(
    mode: DelayMode = DelayMode.Forever,
    frequency: DelayFrequency = DelayFrequency.Once
): Delayable {
    val delayable = remember { Delayable(mode) }

    LaunchedEffect(Unit) {
        when (frequency) {
            is DelayFrequency.Never -> Unit
            is DelayFrequency.Once -> delayable.delay()
            is DelayFrequency.Infinite -> {
                while (true) {
                    delayable.delay()
                    delay(mode.duration)
                }
            }
        }
    }

    return delayable
}
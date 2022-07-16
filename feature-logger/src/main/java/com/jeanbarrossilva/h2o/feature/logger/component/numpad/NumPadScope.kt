package com.jeanbarrossilva.h2o.feature.logger.component.numpad

import android.content.Context
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.DpSize
import com.jeanbarrossilva.h2o.feature.logger.component.numpad.config.NumPadKeySpace
import com.jeanbarrossilva.h2o.feature.logger.component.numpad.config.NumPadKeyType
import com.jeanbarrossilva.h2o.feature.logger.extensions.configuration.screenSize
import com.jeanbarrossilva.h2o.ui.environment.Spacing as _Spacing

internal class NumPadScope {
    @Composable
    fun Key(
        type: NumPadKeyType,
        space: NumPadKeySpace = NumPadKeySpace.Default,
        onClick: () -> Unit
    ) {
        val context = LocalContext.current
        val availableSpace = remember { getAvailableSpace(context) }
        val defaultKeyWidth = availableSpace.width / NumPad.KEYS_PER_ROW - Spacing
        val defaultKeyHeight = availableSpace.height / NumPad.KEYS_PER_COLUMN - Spacing
        val defaultKeySize = DpSize(defaultKeyWidth, defaultKeyHeight)
        val keySize = with(defaultKeySize) {
            copy(width = (width * space.factor) + (Spacing * (space.factor - 1)))
        }

        NumPadKey(
            onClick,
            Modifier.size(keySize),
            type.colors
        ) {
            type.Content()
        }
    }

    fun getAvailableSpace(context: Context): DpSize {
        return with(context.resources.configuration.screenSize) {
            copy(height = height / 2)
        }
    }

    companion object {
        val Spacing = _Spacing.l
    }
}
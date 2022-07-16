package com.jeanbarrossilva.h2o.feature.logger.component.numpad

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.feature.logger.component.numpad.NumPad.KEYS_PER_ROW
import com.jeanbarrossilva.h2o.feature.logger.component.numpad.config.NumPadKeySpace
import com.jeanbarrossilva.h2o.feature.logger.component.numpad.config.NumPadKeyType
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

internal object NumPad {
    const val KEYS_PER_ROW = 3
    const val KEYS_PER_COLUMN = 4
}

@Composable
internal fun NumPad(
    onInput: (digit: Int) -> Unit,
    onEnter: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scope = NumPadScope()
    val spacing = NumPadScope.Spacing
    val availableSpace = scope.getAvailableSpace(context)

    Column(
        modifier.size(availableSpace),
        Arrangement.spacedBy(spacing, Alignment.CenterVertically),
        Alignment.CenterHorizontally
    ) {
        1.rangeTo(9).chunked(KEYS_PER_ROW).forEach { digits ->
            Row(horizontalArrangement = Arrangement.spacedBy(spacing)) {
                digits.forEach {
                    scope.Key(
                        NumPadKeyType.Digit(it),
                        NumPadKeySpace of it,
                        onClick = { onInput(it) }
                    )
                }
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(spacing)) {
            scope.Key(
                NumPadKeyType.Digit(0),
                NumPadKeySpace of 0,
                onClick = { onInput(0) }
            )

            scope.Key(
                NumPadKeyType.Enter,
                onClick = onEnter
            )
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun NumPadPreview() {
    H2OTheme {
        NumPad(
            onInput = { },
            onEnter = { }
        )
    }
}
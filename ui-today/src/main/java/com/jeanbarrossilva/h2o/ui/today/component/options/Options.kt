package com.jeanbarrossilva.h2o.ui.today.component.options

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun Options(
    isHistoryOptionShown: Boolean,
    onIntakeLogRequest: () -> Unit,
    onHistoryRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        Arrangement.spacedBy(Spacing.l, Alignment.CenterHorizontally)
    ) {
        OptionsAddOption(onClick = onIntakeLogRequest)

        AnimatedVisibility(
            isHistoryOptionShown,
            enter = expandIn(expandFrom = Alignment.Center, clip = false) + fadeIn(),
            exit = shrinkOut(shrinkTowards = Alignment.Center, clip = false) + fadeOut()
        ) {
            OptionsHistoryOption(onClick = onHistoryRequest)
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun OptionsPreview() {
    H2OTheme {
        Options(
            isHistoryOptionShown = true,
            onIntakeLogRequest = { },
            onHistoryRequest = { }
        )
    }
}
package com.jeanbarrossilva.h2o.feature.today.component.options

import android.content.res.Configuration
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
    onIntakeLogRequest: () -> Unit,
    onHistoryRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        Arrangement.spacedBy(Spacing.l, Alignment.CenterHorizontally)
    ) {
        OptionsAddOption(onClick = onIntakeLogRequest)
        OptionsHistoryOption(onClick = onHistoryRequest)
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun OptionsPreview() {
    H2OTheme {
        Options(
            onIntakeLogRequest = { },
            onHistoryRequest = { }
        )
    }
}
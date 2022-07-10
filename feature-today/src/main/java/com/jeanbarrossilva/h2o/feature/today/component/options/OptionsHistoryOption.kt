package com.jeanbarrossilva.h2o.feature.today.component.options

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.History
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.feature.today.R
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun OptionsHistoryOption(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick,
        modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        elevation = elevation(0.dp)
    ) {
        Icon(
            Icons.Rounded.History,
            contentDescription = stringResource(R.string.today_history_content_description)
        )
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun OptionsHistoryOptionPreview() {
    H2OTheme {
        OptionsHistoryOption(onClick = { })
    }
}
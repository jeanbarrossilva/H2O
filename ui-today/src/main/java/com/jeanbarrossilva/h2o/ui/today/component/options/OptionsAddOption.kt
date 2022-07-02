package com.jeanbarrossilva.h2o.ui.today.component.options

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import com.jeanbarrossilva.h2o.ui.today.R

@Composable
fun OptionsAddOption(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick,
        modifier,
        elevation = elevation(0.dp)
    ) {
        Icon(
            Icons.Rounded.Add,
            contentDescription = stringResource(R.string.today_log_intake_content_description)
        )
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun OptionsAddOptionPreview() {
    H2OTheme {
        OptionsAddOption(onClick = { })
    }
}
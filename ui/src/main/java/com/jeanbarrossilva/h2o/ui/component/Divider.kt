package com.jeanbarrossilva.h2o.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
fun Divider(modifier: Modifier = Modifier) {
    Divider(
        modifier.clip(CircleShape),
        MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun DividerPreview() {
    H2OTheme {
        Divider()
    }
}
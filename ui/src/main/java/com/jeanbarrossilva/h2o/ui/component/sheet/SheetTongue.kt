package com.jeanbarrossilva.h2o.ui.component.sheet

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun SheetTongue(modifier: Modifier = Modifier) {
    val density = LocalDensity.current
    val color = MaterialTheme.colorScheme.surfaceVariant
    val (width, height) = 64.dp to 8.dp
    val (widthInPx, heightInPx) = with(density) { width.toPx() to height.toPx() }
    val size = Size(widthInPx, heightInPx)
    val cornerRadiusSize = CornerSize(percent = 50).toPx(size, density)
    val cornerRadius = CornerRadius(x = cornerRadiusSize, y = cornerRadiusSize)

    Canvas(modifier.size(width, height)) {
        drawRoundRect(color, size = size, cornerRadius = cornerRadius)
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SheetTonguePreview() {
    H2OTheme {
        SheetTongue()
    }
}
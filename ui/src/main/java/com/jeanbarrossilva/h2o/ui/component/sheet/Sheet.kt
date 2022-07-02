package com.jeanbarrossilva.h2o.ui.component.sheet

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.ui.component.sheet.Sheet.shape
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

object Sheet {
    val shape
        @Composable get() = MaterialTheme.shapes.medium.copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
}

@Composable
fun Sheet(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val spacing = Spacing.l

    Column(
        modifier
            .fillMaxWidth()
            .heightIn(min = 1.dp)
            .shadow(4.dp, shape)
            .clip(shape)
            .background(MaterialTheme.colorScheme.background)
            .padding(spacing),
        Arrangement.spacedBy(spacing),
        Alignment.CenterHorizontally
    ) {
        SheetTongue()
        content()
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SheetPreview() {
    H2OTheme {
        Sheet {
        }
    }
}
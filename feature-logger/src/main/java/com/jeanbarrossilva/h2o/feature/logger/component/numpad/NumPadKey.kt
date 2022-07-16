package com.jeanbarrossilva.h2o.feature.logger.component.numpad

import android.content.res.Configuration
import android.view.MotionEvent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.jeanbarrossilva.h2o.ui.environment.ContentAlpha
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

internal object NumPadKey {
    val colors
        @Composable get() = buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun NumPadKey(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = NumPadKey.colors,
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current
    var size by remember { mutableStateOf(Size.Zero) }
    var isPressing by remember { mutableStateOf(false) }
    val largeShapeRadiusAsPx = MaterialTheme.shapes.large.topStart.toPx(size, density)
    val largeShapeRadius = with(density) { largeShapeRadiusAsPx.toDp() }
    val radiusValue = if (isPressing) 50.dp else largeShapeRadius
    val radius by animateDpAsState(radiusValue)
    val shape = RoundedCornerShape(radius)
    val borderWidthValue = if (isPressing) (-1).dp else 2.dp
    val borderWidth by animateDpAsState(borderWidthValue)

    Button(
        onClick,
        modifier
            .border(
                borderWidth,
                MaterialTheme.colorScheme.onSurface.copy(ContentAlpha.LIGHT),
                shape
            )
            .motionEventSpy { event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> isPressing = true
                    MotionEvent.ACTION_UP -> isPressing = false
                }
            }
            .onGloballyPositioned { size = it.size.toSize() },
        shape = shape,
        colors = colors
    ) {
        ProvideTextStyle(LocalTextStyle.current.copy(fontWeight = FontWeight.Bold)) {
            content()
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun NumPadKeyPreview() {
    H2OTheme {
        NumPadKey(
            onClick = { },
            Modifier.size(128.dp)
        ) {
            Text("8")
        }
    }
}
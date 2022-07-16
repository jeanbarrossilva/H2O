package com.jeanbarrossilva.h2o.feature.logger.component.numpad.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jeanbarrossilva.h2o.feature.logger.R
import com.jeanbarrossilva.h2o.feature.logger.component.numpad.NumPadKey

internal sealed interface NumPadKeyType {
    @get:Composable
    val colors: ButtonColors

    @Composable
    fun Content()

    data class Digit(val value: Int): NumPadKeyType {
        override val colors
            @Composable get() = NumPadKey.colors

        @Composable
        override fun Content() {
            Text("$value")
        }
    }
    
    object Enter: NumPadKeyType {
        override val colors
            @Composable get() = buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )

        @Composable
        override fun Content() {
            Icon(
                Icons.Default.Done,
                contentDescription = stringResource(R.string.logger_log)
            )
        }
    }
}
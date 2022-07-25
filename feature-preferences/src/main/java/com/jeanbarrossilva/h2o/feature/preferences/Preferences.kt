package com.jeanbarrossilva.h2o.feature.preferences

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.feature.preferences.component.IntakeGoalPreference
import com.jeanbarrossilva.h2o.model.extensions.intakestatus.orZero
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun Preferences(
    viewModel: PreferencesViewModel,
    modifier: Modifier = Modifier
) {
    var status by remember { mutableStateOf(IntakeStatus.zero) }

    LaunchedEffect(Unit) {
        status = viewModel.getIntakeStatus().orZero
    }

    Preferences(
        status,
        modifier
    )
}

@Composable
internal fun Preferences(
    status: IntakeStatus,
    modifier: Modifier = Modifier
) {
    Background(modifier) {
        IntakeGoalPreference(status)
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun PreferencesPreview() {
    H2OTheme {
        Preferences(IntakeStatus.sample)
    }
}
package com.jeanbarrossilva.h2o.feature.preferences.component

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.feature.preferences.R
import com.jeanbarrossilva.h2o.feature.preferences.component.preference.Preference
import com.jeanbarrossilva.h2o.feature.preferences.extensions.intake.format
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun IntakeGoalPreference(
    status: IntakeStatus,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Preference(
        modifier,
        trailing = { Text(status.goal.format(context)) }
    ) {
        Text(stringResource(R.string.preference_option_title_intake_goal))
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun IntakeGoalPreferencePreview() {
    H2OTheme {
        IntakeGoalPreference(IntakeStatus.sample)
    }
}
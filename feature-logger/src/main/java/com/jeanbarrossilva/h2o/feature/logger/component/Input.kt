package com.jeanbarrossilva.h2o.feature.logger.component

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.feature.logger.extensions.intake.format
import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun Input(
    intake: Intake,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val formattedIntake = intake.format(context)

    Text(
        formattedIntake,
        modifier,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun InputPreview() {
    H2OTheme {
        Input(Intake.sample)
    }
}
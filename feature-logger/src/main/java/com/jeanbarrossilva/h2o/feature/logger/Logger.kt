package com.jeanbarrossilva.h2o.feature.logger

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.jeanbarrossilva.h2o.feature.logger.component.Input
import com.jeanbarrossilva.h2o.feature.logger.component.numpad.NumPad
import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun Logger(
    viewModel: LoggerViewModel,
    modifier: Modifier = Modifier
) {
    val intake by viewModel.getIntakeFlow().collectAsState()

    Logger(
        intake,
        onIntakeChange = viewModel::setIntake,
        onLog = viewModel::log,
        modifier
    )
}

@Composable
private fun Logger(
    intake: Intake,
    onIntakeChange: (Intake) -> Unit,
    onLog: () -> Unit,
    modifier: Modifier = Modifier
) {
    Background(modifier) {
        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .padding(Spacing.l)
        ) {
            val (inputRef, numPadRef) = createRefs()

            Input(
                intake,
                Modifier.constrainAs(inputRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(numPadRef.top)
                }
            )

            NumPad(
                onInput = {
                    val milliliters = "${intake.milliliters}".plus(it).toLong()
                    val newIntake = Intake(milliliters)
                    onIntakeChange(newIntake)
                },
                onEnter = onLog,
                Modifier.constrainAs(numPadRef) { bottom.linkTo(parent.bottom) }
            )
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun LoggerPreview() {
    H2OTheme {
        Logger(
            Intake.sample,
            onIntakeChange = { },
            onLog = { }
        )
    }
}
package com.jeanbarrossilva.h2o.ui.today.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.h2o.model.intake.IntakeLog
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.component.chart.bar.BarChart
import com.jeanbarrossilva.h2o.ui.extensions.localdatetime.format
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun FrequencyChart(
    logs: List<IntakeLog>,
    modifier: Modifier = Modifier
) {
    val barColor = MaterialTheme.colorScheme.primary

    BarChart(modifier.fillMaxWidth()) {
        logs.forEach { log ->
            bar(
                barColor,
                amount = log.intake.milliliters,
                label = log.creationMoment.format()
            )
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun FrequencyChartPreview() {
    H2OTheme {
        Background(isFilling = false) {
            FrequencyChart(IntakeLog.samples)
        }
    }
}
package com.jeanbarrossilva.h2o.ui.today.component

import android.content.res.Configuration
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.jeanbarrossilva.h2o.logger.intake.Intake
import com.jeanbarrossilva.h2o.ui.environment.ContentAlpha
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme
import com.jeanbarrossilva.h2o.ui.today.R
import com.jeanbarrossilva.h2o.ui.today.extensions.chart.piechart.clean
import com.jeanbarrossilva.h2o.ui.today.extensions.number.formatted

@Composable
internal fun IntakeChart(
    intake: Intake,
    intakeGoalInMilliliters: Long,
    modifier: Modifier = Modifier
) {
    val chartSize = 264.dp
    val statusShape = CircleShape
    val intakePercentage = intake.milliliters.toFloat() / intakeGoalInMilliliters.toFloat()
    val intakeEntry = PieEntry(intakePercentage)
    val intakeEntryColorValue = MaterialTheme.colorScheme.primary.toArgb()
    val remainingIntakeEntry = PieEntry(1f - intakePercentage)
    val remainingIntakeEntryColorValue = Color.TRANSPARENT
    val entries = listOf(intakeEntry, remainingIntakeEntry)
    val dataSetLabel = ""
    val dataSet = PieDataSet(entries, dataSetLabel).apply {
        colors = listOf(intakeEntryColorValue, remainingIntakeEntryColorValue)
    }
    val data = PieData(dataSet)

    Box(
        modifier,
        Alignment.Center
    ) {
        AndroidView(
            factory = { PieChart(it) },
            Modifier.size(chartSize)
        ) { view ->
            view.data = data
            view.clean()
        }

        ProvideTextStyle(
            LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        ) {
            Column(
                Modifier
                    .size(chartSize / 1.24f)
                    .padding(Spacing.m)
                    .shadow(16.dp, statusShape)
                    .clip(statusShape)
                    .background(MaterialTheme.colorScheme.surface),
                Arrangement.spacedBy(Spacing.s, Alignment.CenterVertically),
                Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(R.string.today_intake).format(intake.milliliters.formatted),
                    fontWeight = FontWeight.Bold,
                    style = LocalTextStyle.current + MaterialTheme.typography.headlineMedium
                )

                Text(
                    stringResource(R.string.today_intake_chart_intake_total)
                        .format(intakeGoalInMilliliters.formatted),
                    color = LocalTextStyle.current.color.copy(ContentAlpha.MEDIUM),
                    style = LocalTextStyle.current + MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun IntakeChartPreview() {
    H2OTheme {
        IntakeChart(
            Intake.sample,
            intakeGoalInMilliliters = 4_500L
        )
    }
}
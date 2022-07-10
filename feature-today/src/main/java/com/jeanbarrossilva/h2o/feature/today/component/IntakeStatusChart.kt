package com.jeanbarrossilva.h2o.feature.today.component

import android.content.res.Configuration
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.h2o.feature.today.R
import com.jeanbarrossilva.h2o.model.extensions.intakestatus.percentage
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.ui.component.chart.Chart
import com.jeanbarrossilva.h2o.ui.component.chart.pie.PieChart
import com.jeanbarrossilva.h2o.ui.environment.ContentAlpha
import com.jeanbarrossilva.h2o.ui.environment.Spacing
import com.jeanbarrossilva.h2o.ui.extensions.number.format
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
internal fun IntakeStatusChart(
    status: IntakeStatus,
    modifier: Modifier = Modifier
) {
    val statusShape = CircleShape
    val sliceColor = MaterialTheme.colorScheme.primary

    Box(
        modifier,
        Alignment.Center
    ) {
        PieChart {
            slice(sliceColor, status.percentage)
            slice(Color.Transparent, 1f - status.percentage)
        }

        ProvideTextStyle(
            LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        ) {
            Column(
                Modifier
                    .size(Chart.Size / 1.24f)
                    .padding(Spacing.l)
                    .shadow(4.dp, statusShape)
                    .clip(statusShape)
                    .background(MaterialTheme.colorScheme.surface),
                Arrangement.spacedBy(Spacing.s, Alignment.CenterVertically),
                Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(com.jeanbarrossilva.h2o.ui.R.string.intake)
                        .format(status.current.milliliters.format()),
                    style = LocalTextStyle.current + MaterialTheme.typography.headlineMedium
                )

                Text(
                    stringResource(R.string.today_intake_chart_intake_total)
                        .format(status.goal.milliliters.format()),
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
private fun IntakeStatusChartPreview() {
    H2OTheme {
        IntakeStatusChart(IntakeStatus.sample)
    }
}
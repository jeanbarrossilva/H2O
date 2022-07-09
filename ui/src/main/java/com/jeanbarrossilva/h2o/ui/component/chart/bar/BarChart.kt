package com.jeanbarrossilva.h2o.ui.component.chart.bar

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.BarChart
import com.jeanbarrossilva.h2o.ui.component.Background
import com.jeanbarrossilva.h2o.ui.component.chart.Chart
import com.jeanbarrossilva.h2o.ui.component.chart.bar.scope.BarChartScope
import com.jeanbarrossilva.h2o.ui.component.chart.bar.scope.DefaultBarChartScope
import com.jeanbarrossilva.h2o.ui.extensions.barchartscope.toBarData
import com.jeanbarrossilva.h2o.ui.extensions.chart.barchart.clean
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
fun BarChart(
    modifier: Modifier = Modifier,
    updater: BarChartUpdater
) {
    BarChart(
        DefaultBarChartScope(),
        modifier,
        updater
    )
}

@Composable
@Suppress("UnnecessaryVariable")
private fun BarChart(
    scope: BarChartScope,
    modifier: Modifier = Modifier,
    updater: BarChartUpdater
) {
    val density = LocalDensity.current
    val textColor = MaterialTheme.colorScheme.onSurfaceVariant
    val gridColor = textColor

    AndroidView(
        factory = { BarChart(it) },
        modifier.size(Chart.Size)
    ) { view ->
        with(updater) { scope.update() }
        view.data = scope.toBarData()
        view.clean(density, scope.getBars(), textColor, gridColor)
    }
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun BarChartPreview() {
    H2OTheme {
        Background(isFilling = false) {
            BarChart(updater = BarChartUpdater.sample)
        }
    }
}
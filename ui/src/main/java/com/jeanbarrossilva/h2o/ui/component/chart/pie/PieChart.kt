package com.jeanbarrossilva.h2o.ui.component.chart.pie

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.PieChart
import com.jeanbarrossilva.h2o.ui.component.chart.Chart
import com.jeanbarrossilva.h2o.ui.component.chart.pie.scope.DefaultPieChartScope
import com.jeanbarrossilva.h2o.ui.component.chart.pie.scope.PieChartScope
import com.jeanbarrossilva.h2o.ui.extensions.chart.piechart.clean
import com.jeanbarrossilva.h2o.ui.extensions.piechartscope.toPieData
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    updater: PieChartUpdater
) {
    PieChart(
        DefaultPieChartScope(),
        modifier,
        updater
    )
}

@Composable
private fun PieChart(
    scope: PieChartScope,
    modifier: Modifier = Modifier,
    updater: PieChartUpdater
) {
    AndroidView(
        factory = { PieChart(it) },
        modifier.size(Chart.Size)
    ) { view ->
        with(updater) { scope.update() }
        view.data = scope.toPieData()
        view.clean()
    }
}

@Composable
@Preview
private fun PieChartPreview() {
    H2OTheme {
        PieChart(updater = PieChartUpdater.sample)
    }
}
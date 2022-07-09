package com.jeanbarrossilva.h2o.ui.extensions.chart.barchart

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.jeanbarrossilva.h2o.ui.component.chart.bar.Bar
import com.jeanbarrossilva.h2o.ui.component.chart.bar.RoundedBarChartRenderer
import com.jeanbarrossilva.h2o.ui.extensions.chart.clean

internal fun BarChart.clean(
    density: Density,
    bars: List<Bar>,
    textColor: Color,
    gridColor: Color
) {
    val radius = 12.dp
    val radiusInPx = with(density) { radius.toPx() }
    val labels = bars.map(Bar::label)
    val textColorValue = textColor.toArgb()
    val gridColorValue = gridColor.toArgb()

    clean()
    setPinchZoom(false)
    renderer =
        RoundedBarChartRenderer(this, animator, viewPortHandler).apply { setRadius(radiusInPx) }
    xAxis?.setDrawAxisLine(false)
    xAxis?.setDrawGridLines(false)
    xAxis?.position = XAxis.XAxisPosition.BOTTOM
    xAxis?.valueFormatter = IndexAxisValueFormatter(labels)
    xAxis?.textColor = textColorValue
    axisLeft?.gridColor = gridColorValue
    axisLeft?.setDrawLabels(false)
    axisLeft?.setDrawAxisLine(false)
    axisRight?.setDrawGridLines(false)
    axisRight?.axisLineColor = gridColorValue
    axisRight?.textColor = textColorValue
    barData?.isHighlightEnabled = false
}
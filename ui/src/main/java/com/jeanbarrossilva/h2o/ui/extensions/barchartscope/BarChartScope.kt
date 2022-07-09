package com.jeanbarrossilva.h2o.ui.extensions.barchartscope

import androidx.compose.ui.graphics.toArgb
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.jeanbarrossilva.h2o.ui.component.chart.bar.scope.BarChartScope
import com.jeanbarrossilva.h2o.ui.extensions.bar.toBarEntry

internal fun BarChartScope.toBarData(): BarData {
    val dataSet = toBarDataSet()
    return BarData(dataSet)
}

internal fun BarChartScope.toBarDataSet(): BarDataSet {
    val bars = getBars()
    val entries = bars.mapIndexed { index, bar -> bar.toBarEntry(index) }
    val label = ""

    return BarDataSet(entries, label).apply {
        colors = bars.map {
            it.color.toArgb()
        }
    }
}
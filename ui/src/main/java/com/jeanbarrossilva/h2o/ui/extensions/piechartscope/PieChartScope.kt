package com.jeanbarrossilva.h2o.ui.extensions.piechartscope

import androidx.compose.ui.graphics.toArgb
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.jeanbarrossilva.h2o.ui.component.chart.pie.Slice
import com.jeanbarrossilva.h2o.ui.component.chart.pie.scope.PieChartScope
import com.jeanbarrossilva.h2o.ui.extensions.slice.toPieEntry

internal fun PieChartScope.toPieData(): PieData {
    val dataSet = toPieDataSet()
    return PieData(dataSet)
}

internal fun PieChartScope.toPieDataSet(): PieDataSet {
    val slices = getSlices()
    val entries = slices.map(Slice::toPieEntry)
    val label = ""

    return  PieDataSet(entries, label).apply {
        colors = slices.map {
            it.color.toArgb()
        }
    }
}
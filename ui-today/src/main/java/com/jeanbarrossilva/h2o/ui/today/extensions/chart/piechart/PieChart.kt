package com.jeanbarrossilva.h2o.ui.today.extensions.chart.piechart

import com.github.mikephil.charting.charts.PieChart
import com.jeanbarrossilva.h2o.ui.today.extensions.chart.clean

internal fun PieChart.clean() {
    clean()
    isDrawHoleEnabled = false
    setDrawCenterText(false)
    setDrawEntryLabels(false)
}
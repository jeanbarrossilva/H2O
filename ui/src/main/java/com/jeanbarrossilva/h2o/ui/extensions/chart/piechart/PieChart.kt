package com.jeanbarrossilva.h2o.ui.extensions.chart.piechart

import com.github.mikephil.charting.charts.PieChart
import com.jeanbarrossilva.h2o.ui.extensions.chart.clean
import com.jeanbarrossilva.h2o.ui.extensions.view.setScale

internal fun PieChart.clean() {
    clean()
    setScale(1.05f)
    isDrawHoleEnabled = false
    setDrawCenterText(false)
    setDrawEntryLabels(false)
}
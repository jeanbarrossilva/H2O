package com.jeanbarrossilva.h2o.ui.extensions.chart

import com.github.mikephil.charting.charts.Chart
import com.jeanbarrossilva.h2o.ui.extensions.onchartvalueselectedlistener.OnChartValueSelectedListener
import com.jeanbarrossilva.h2o.ui.extensions.view.setScale

internal fun Chart<*>.clean() {
    description?.isEnabled = false
    data?.setDrawValues(false)
    legend?.isEnabled = false
    setNoDataText("")
    disableValueHighlighting()
}

internal fun Chart<*>.disableValueHighlighting() {
    setOnChartValueSelectedListener(OnChartValueSelectedListener { _, _ ->
        onTouchListener.setLastHighlighted(null)
        highlightValue(null)
    })
}
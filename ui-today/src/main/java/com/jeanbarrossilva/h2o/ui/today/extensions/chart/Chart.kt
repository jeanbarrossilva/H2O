package com.jeanbarrossilva.h2o.ui.today.extensions.chart

import com.github.mikephil.charting.charts.Chart
import com.jeanbarrossilva.h2o.ui.extensions.view.setScale
import com.jeanbarrossilva.h2o.ui.today.extensions.onchartvalueselectedlistener.OnChartValueSelectedListener

internal fun Chart<*>.clean() {
    description?.isEnabled = false
    data?.setDrawValues(false)
    legend?.isEnabled = false
    setScale(1.05f)
    setNoDataText("")
    disableValueHighlighting()
}

internal fun Chart<*>.disableValueHighlighting() {
    setOnChartValueSelectedListener(OnChartValueSelectedListener { _, _ ->
        onTouchListener.setLastHighlighted(null)
        highlightValue(null)
    })
}

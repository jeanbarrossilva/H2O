package com.jeanbarrossilva.h2o.ui.extensions.bar

import com.github.mikephil.charting.data.BarEntry
import com.jeanbarrossilva.h2o.ui.component.chart.bar.Bar

internal fun Bar.toBarEntry(index: Int): BarEntry {
    val x = index.toFloat()
    val amountValue = amount.value.toFloat()

    return BarEntry(x, amountValue, label)
}
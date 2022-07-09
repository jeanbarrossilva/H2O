package com.jeanbarrossilva.h2o.ui.extensions.slice

import com.github.mikephil.charting.data.PieEntry
import com.jeanbarrossilva.h2o.ui.component.chart.pie.Slice

internal fun Slice.toPieEntry(): PieEntry {
    return PieEntry(percentage)
}
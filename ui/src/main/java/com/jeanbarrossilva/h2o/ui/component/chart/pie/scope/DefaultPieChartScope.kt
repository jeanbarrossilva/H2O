package com.jeanbarrossilva.h2o.ui.component.chart.pie.scope

import androidx.compose.ui.graphics.Color
import com.jeanbarrossilva.h2o.ui.component.chart.pie.Slice

internal class DefaultPieChartScope: PieChartScope() {
    private val entries = mutableListOf<Slice>()

    override fun slice(color: Color, percentage: Float) {
        val entry = Slice(color, percentage)
        entries.add(entry)
    }

    override fun getSlices(): List<Slice> {
        return entries.toList()
    }
}
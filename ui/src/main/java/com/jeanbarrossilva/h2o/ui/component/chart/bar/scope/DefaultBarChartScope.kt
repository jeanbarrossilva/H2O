package com.jeanbarrossilva.h2o.ui.component.chart.bar.scope

import androidx.compose.ui.graphics.Color
import com.jeanbarrossilva.h2o.ui.component.chart.bar.Bar
import com.jeanbarrossilva.h2o.ui.component.chart.bar.BarAmount

class DefaultBarChartScope: BarChartScope() {
    private val bars = mutableListOf<Bar>()

    override fun <T: Number> bar(color: Color, label: String, amount: T, format: (T) -> String) {
        val barAmount = BarAmount(amount, format(amount))
        val bar = Bar(color, barAmount, label)

        bars.add(bar)
    }

    override fun getBars(): List<Bar> {
        return bars.toList()
    }
}
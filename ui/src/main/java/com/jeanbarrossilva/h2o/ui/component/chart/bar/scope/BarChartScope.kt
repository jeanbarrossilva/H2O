package com.jeanbarrossilva.h2o.ui.component.chart.bar.scope

import androidx.compose.ui.graphics.Color
import com.jeanbarrossilva.h2o.ui.component.chart.bar.Bar
import com.jeanbarrossilva.h2o.ui.extensions.number.format

abstract class BarChartScope {
    abstract fun <T: Number> bar(
        color: Color,
        label: String,
        amount: T,
        format: (T) -> String = Number::format
    )

    internal abstract fun getBars(): List<Bar>
}
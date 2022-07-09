package com.jeanbarrossilva.h2o.ui.component.chart.pie.scope

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color
import com.jeanbarrossilva.h2o.ui.component.chart.pie.Slice

abstract class PieChartScope {
    abstract fun slice(color: Color, @FloatRange(from = 0.0, to = 1.0) percentage: Float)

    internal abstract fun getSlices(): List<Slice>
}
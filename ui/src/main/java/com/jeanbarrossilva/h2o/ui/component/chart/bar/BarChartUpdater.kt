package com.jeanbarrossilva.h2o.ui.component.chart.bar

import androidx.compose.ui.graphics.Color
import com.jeanbarrossilva.h2o.ui.component.chart.bar.scope.BarChartScope

fun interface BarChartUpdater {
    fun BarChartScope.update()

    companion object {
        val sample = BarChartUpdater {
            bar(Color.Cyan, "January", 325f)
            bar(Color.Magenta, "February", 510f)
            bar(Color.LightGray, "March", 200f)
        }
    }
}
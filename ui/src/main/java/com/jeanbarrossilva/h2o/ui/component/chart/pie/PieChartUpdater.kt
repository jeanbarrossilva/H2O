package com.jeanbarrossilva.h2o.ui.component.chart.pie

import androidx.compose.ui.graphics.Color
import com.jeanbarrossilva.h2o.ui.component.chart.pie.scope.PieChartScope

fun interface PieChartUpdater {
    fun PieChartScope.update()

    companion object {
        val sample = PieChartUpdater {
            slice(Color.Cyan, .3f)
            slice(Color.Magenta, .5f)
            slice(Color.LightGray, .2f)
        }
    }
}
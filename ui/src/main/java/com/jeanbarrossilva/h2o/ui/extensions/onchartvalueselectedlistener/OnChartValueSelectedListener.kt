package com.jeanbarrossilva.h2o.ui.extensions.onchartvalueselectedlistener

import com.github.mikephil.charting.listener.OnChartValueSelectedListener

internal fun interface OnChartValueSelectedListener: OnChartValueSelectedListener {
    override fun onNothingSelected() {
    }
}
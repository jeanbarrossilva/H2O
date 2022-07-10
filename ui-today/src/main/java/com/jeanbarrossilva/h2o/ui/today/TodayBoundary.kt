package com.jeanbarrossilva.h2o.ui.today

import androidx.fragment.app.FragmentActivity

interface TodayBoundary {
    fun navigateToIntakeLogger()

    fun navigateToHistory(activity: FragmentActivity?)
}
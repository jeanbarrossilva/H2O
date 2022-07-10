package com.jeanbarrossilva.h2o.feature.today

import androidx.fragment.app.FragmentActivity

interface TodayBoundary {
    fun navigateToIntakeLogger()

    fun navigateToHistory(activity: FragmentActivity?)
}
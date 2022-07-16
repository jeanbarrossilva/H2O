package com.jeanbarrossilva.h2o.feature.today

import android.content.Context
import androidx.fragment.app.FragmentActivity

interface TodayBoundary {
    fun navigateToLogger(context: Context?)

    fun navigateToHistory(activity: FragmentActivity?)
}
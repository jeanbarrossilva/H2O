package com.jeanbarrossilva.h2o.boundary

import androidx.fragment.app.FragmentActivity
import com.jeanbarrossilva.h2o.ui.history.HistoryFragment
import com.jeanbarrossilva.h2o.ui.today.TodayBoundary

class DefaultTodayBoundary: TodayBoundary {
    override fun navigateToIntakeLogger() {
        TODO()
    }

    override fun navigateToHistory(activity: FragmentActivity?) {
        HistoryFragment.show(activity)
    }
}
package com.jeanbarrossilva.h2o.boundary

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.jeanbarrossilva.h2o.extensions.context.startActivity
import com.jeanbarrossilva.h2o.feature.history.HistoryFragment
import com.jeanbarrossilva.h2o.feature.logger.LoggerActivity
import com.jeanbarrossilva.h2o.feature.today.TodayBoundary

class DefaultTodayBoundary: TodayBoundary {
    override fun navigateToLogger(context: Context?) {
        context?.startActivity<LoggerActivity>()
    }

    override fun navigateToHistory(activity: FragmentActivity?) {
        HistoryFragment.show(activity)
    }
}
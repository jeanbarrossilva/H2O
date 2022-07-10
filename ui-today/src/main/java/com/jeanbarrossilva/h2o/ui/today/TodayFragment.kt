package com.jeanbarrossilva.h2o.ui.today

import androidx.compose.runtime.Composable
import com.jeanbarrossilva.h2o.ui.template.composable.ComposableFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class TodayFragment: ComposableFragment() {
    private val viewModel by viewModel<TodayViewModel>()
    private val boundary by inject<TodayBoundary>()

    @Composable
    override fun Content() {
        Today(
            activity,
            viewModel,
            boundary
        )
    }
}
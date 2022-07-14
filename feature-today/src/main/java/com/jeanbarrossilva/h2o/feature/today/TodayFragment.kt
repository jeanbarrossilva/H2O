package com.jeanbarrossilva.h2o.feature.today

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.jeanbarrossilva.h2o.feature.today.component.Commemoration
import com.jeanbarrossilva.h2o.ui.template.composable.ComposableFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class TodayFragment: ComposableFragment() {
    private val viewModel by viewModel<TodayViewModel>()
    private val boundary by inject<TodayBoundary>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        commemorateOnAnnouncement()
    }

    @Composable
    override fun Content() {
        Today(
            activity,
            viewModel,
            boundary
        )
    }

    private fun commemorateOnAnnouncement() {
        viewModel.doOnAnnouncement(Commemoration.Delayable::delay)
    }
}
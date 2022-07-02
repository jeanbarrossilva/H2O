package com.jeanbarrossilva.h2o.ui.today

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.preferences.PreferenceManager
import com.jeanbarrossilva.h2o.ui.extensions.factory.viewModelFactoryOf
import com.jeanbarrossilva.h2o.ui.template.ComposableFragment
import org.koin.android.ext.android.inject

internal class TodayFragment: ComposableFragment() {
    private val preferenceManager by inject<PreferenceManager>()
    private val logger by inject<Logger>()
    private val viewModel by viewModels<TodayViewModel> {
        viewModelFactoryOf(preferenceManager, logger)
    }

    @Composable
    override fun Content() {
        Today(
            viewModel,
            onIntakeLogRequest = ::TODO
        )
    }
}
package com.jeanbarrossilva.h2o.feature.preferences

import androidx.compose.runtime.Composable
import com.jeanbarrossilva.h2o.ui.template.composable.ComposableFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class PreferencesFragment: ComposableFragment() {
    private val viewModel by viewModel<PreferencesViewModel>()

    @Composable
    override fun Content() {
        Preferences(viewModel)
    }
}
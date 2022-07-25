package com.jeanbarrossilva.h2o.feature.preferences

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val preferencesModule = module {
    viewModel {
        PreferencesViewModel(preferenceManager = get())
    }
}
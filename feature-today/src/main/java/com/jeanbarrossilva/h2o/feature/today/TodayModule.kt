package com.jeanbarrossilva.h2o.feature.today

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val todayModule = module {
    viewModel {
        TodayViewModel(preferenceManager = get(), logger = get())
    }
}
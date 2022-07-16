package com.jeanbarrossilva.h2o.feature.logger

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loggerModule = module {
    viewModel {
        LoggerViewModel(logger = get())
    }
}
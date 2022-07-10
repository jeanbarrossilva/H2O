package com.jeanbarrossilva.h2o.ui.history

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val historyModule = module {
    viewModel {
        HistoryViewModel(logger = get())
    }
}
package com.jeanbarrossilva.h2o.ui.today

import com.jeanbarrossilva.h2o.logger.InMemoryLogger
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.logger.time.DefaultMomentProvider
import com.jeanbarrossilva.h2o.logger.time.MomentProvider
import com.jeanbarrossilva.h2o.preferences.InMemoryPreferenceManager
import com.jeanbarrossilva.h2o.preferences.PreferenceManager
import org.koin.dsl.module

val todayModule = module {
    single<PreferenceManager> { InMemoryPreferenceManager() }
    single<MomentProvider> { DefaultMomentProvider }
    single<Logger> { InMemoryLogger(momentProvider = get()) }
}
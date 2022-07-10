package com.jeanbarrossilva.h2o.injection

import com.jeanbarrossilva.h2o.boundary.DefaultTodayBoundary
import com.jeanbarrossilva.h2o.feature.today.TodayBoundary
import org.koin.dsl.module

val boundaryModule = module {
    single<TodayBoundary> {
        DefaultTodayBoundary()
    }
}
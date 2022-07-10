package com.jeanbarrossilva.h2o

import android.app.Application
import com.jeanbarrossilva.h2o.injection.boundaryModule
import com.jeanbarrossilva.h2o.feature.history.historyModule
import com.jeanbarrossilva.h2o.feature.today.todayModule
import org.koin.core.context.startKoin

class H2OApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            modules(h2oModule, boundaryModule, todayModule, historyModule)
        }
    }
}
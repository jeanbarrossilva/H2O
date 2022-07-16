package com.jeanbarrossilva.h2o

import android.app.Application
import com.jeanbarrossilva.h2o.feature.history.historyModule
import com.jeanbarrossilva.h2o.feature.logger.loggerModule
import com.jeanbarrossilva.h2o.feature.today.todayModule
import com.jeanbarrossilva.h2o.injection.boundaryModule
import org.koin.core.context.startKoin

class H2OApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            modules(h2oModule, boundaryModule)
            modules(historyModule, loggerModule, todayModule)
        }
    }
}
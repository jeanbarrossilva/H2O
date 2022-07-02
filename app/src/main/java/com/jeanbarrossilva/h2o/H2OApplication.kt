package com.jeanbarrossilva.h2o

import android.app.Application
import com.jeanbarrossilva.h2o.ui.today.todayModule
import org.koin.core.context.startKoin

class H2OApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            modules(todayModule)
        }
    }
}
package com.jeanbarrossilva.h2o.ui.history

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.model.intake.IntakeLog

internal class HistoryViewModel(private val logger: Logger): ViewModel() {
    suspend fun getLogs(): List<IntakeLog> {
        return logger.getLogs()
    }
}
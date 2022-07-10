package com.jeanbarrossilva.h2o.feature.today

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.model.extensions.intakestatus.orZero
import com.jeanbarrossilva.h2o.model.intake.IntakeLog
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.preferences.PreferenceManager

internal class TodayViewModel(
    private val preferenceManager: PreferenceManager,
    private val logger: Logger
): ViewModel() {
    suspend fun getIntakeStatus(): IntakeStatus {
        return preferenceManager.getIntakeStatus().orZero
    }

    suspend fun getLogs(): List<IntakeLog> {
        return logger.getLogs()
    }
}
package com.jeanbarrossilva.h2o.ui.today

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.logger.extensions.intake.orZero
import com.jeanbarrossilva.h2o.logger.intake.Intake
import com.jeanbarrossilva.h2o.logger.intake.IntakeLog
import com.jeanbarrossilva.h2o.preferences.PreferenceManager

internal class TodayViewModel(
    private val preferenceManager: PreferenceManager,
    private val logger: Logger
): ViewModel() {
    suspend fun getIntake(): Intake {
        return preferenceManager.getIntake().orZero
    }

    suspend fun getIntakeGoal(): Long {
        return preferenceManager.getIntakeGoal() ?: 0
    }

    suspend fun getLogs(): List<IntakeLog> {
        return logger.getLogs()
    }
}
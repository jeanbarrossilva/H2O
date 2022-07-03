package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.model.drinker.Drinker
import com.jeanbarrossilva.h2o.model.intake.Intake

interface PreferenceManager {
    suspend fun getDrinker(): Drinker?

    suspend fun setDrinker(drinker: Drinker)

    suspend fun getIntake(): Intake?

    suspend fun setIntake(intake: Intake)

    suspend fun getIntakeGoal(): Long?

    suspend fun setIntakeGoal(intakeGoal: Long)

    suspend fun reset()
}
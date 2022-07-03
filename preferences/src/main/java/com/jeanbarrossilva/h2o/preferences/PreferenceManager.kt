package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.model.drinker.Drinker
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus

interface PreferenceManager {
    suspend fun getDrinker(): Drinker?

    suspend fun setDrinker(drinker: Drinker)

    suspend fun getIntakeStatus(): IntakeStatus?

    suspend fun setIntakeStatus(intakeStatus: IntakeStatus)

    suspend fun reset()
}
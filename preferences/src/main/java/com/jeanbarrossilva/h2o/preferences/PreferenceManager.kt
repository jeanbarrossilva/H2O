package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.drinker.Drinker

interface PreferenceManager {
    suspend fun getDrinker(): Drinker?

    suspend fun setDrinker(drinker: Drinker)

    suspend fun getIntakeGoal(): Long?

    suspend fun setIntakeGoal(intakeGoal: Long)

    suspend fun reset()
}
package com.jeanbarrossilva.h2o.preferences

interface PreferenceManager {
    suspend fun getIntakeGoal(): Long?

    suspend fun setIntakeGoal(intakeGoal: Long)

    suspend fun reset()
}
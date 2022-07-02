package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.drinker.Drinker
import com.jeanbarrossilva.h2o.logger.intake.Intake

class InMemoryPreferenceManager: PreferenceManager {
    private val preferences = mutableMapOf<String, Any?>(
        KEY_DRINKER to null,
        KEY_INTAKE to null,
        KEY_INTAKE_GOAL to null
    )

    override suspend fun getDrinker(): Drinker? {
        return preferences[KEY_DRINKER] as Drinker?
    }

    override suspend fun setDrinker(drinker: Drinker) {
        preferences[KEY_DRINKER] = drinker
    }

    override suspend fun getIntake(): Intake? {
        return preferences[KEY_INTAKE] as Intake?
    }

    override suspend fun setIntake(intake: Intake) {
        preferences[KEY_INTAKE] = intake
    }

    override suspend fun getIntakeGoal(): Long? {
        return preferences[KEY_INTAKE_GOAL] as Long?
    }

    override suspend fun setIntakeGoal(intakeGoal: Long) {
        preferences[KEY_INTAKE_GOAL] = intakeGoal
    }

    override suspend fun reset() {
        preferences.replaceAll { _, _ ->
            null
        }
    }

    companion object {
        private const val KEY_DRINKER = "drinker"
        private const val KEY_INTAKE  = "intake"
        private const val KEY_INTAKE_GOAL = "intake_goal"
    }
}
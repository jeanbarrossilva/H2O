package com.jeanbarrossilva.h2o.preferences

class InMemoryPreferenceManager: PreferenceManager {
    private val preferences = mutableMapOf<String, Any?>(KEY_INTAKE_GOAL to null)

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
        private const val KEY_INTAKE_GOAL = "intake_goal"
    }
}
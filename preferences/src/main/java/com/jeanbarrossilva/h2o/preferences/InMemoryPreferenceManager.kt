package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.model.drinker.Drinker
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus

class InMemoryPreferenceManager: PreferenceManager {
    private var drinker: Drinker? = null
    private var intakeStatus: IntakeStatus? = null

    override suspend fun getDrinker(): Drinker? {
        return drinker
    }

    override suspend fun setDrinker(drinker: Drinker) {
        this.drinker = drinker
    }

    override suspend fun getIntakeStatus(): IntakeStatus? {
        return intakeStatus
    }

    override suspend fun setIntakeStatus(intakeStatus: IntakeStatus) {
        this.intakeStatus = intakeStatus
    }

    override suspend fun reset() {
        drinker = null
        intakeStatus = null
    }
}
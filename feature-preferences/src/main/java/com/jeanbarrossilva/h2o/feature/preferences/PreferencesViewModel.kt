package com.jeanbarrossilva.h2o.feature.preferences

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.preferences.PreferenceManager
import com.jeanbarrossilva.h2o.preferences.preference.Preference

internal class PreferencesViewModel(private val preferenceManager: PreferenceManager): ViewModel() {
    suspend fun getIntakeStatus(): IntakeStatus? {
        return preferenceManager.get(Preference.IntakeStatus)
    }
}
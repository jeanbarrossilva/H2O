package com.jeanbarrossilva.h2o.announcer

import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.preferences.preference.OnPreferenceChangeListener
import com.jeanbarrossilva.h2o.preferences.preference.Preference

class Announcer(private val listener: OnAnnouncementListener): OnPreferenceChangeListener {
    override suspend fun <V : Any, P : Preference<V>> onPreferenceChange(preference: P, value: V) {
        if (preference is Preference.IntakeStatus && value is IntakeStatus) {
            maybeAnnounce(value)
        }
    }

    private suspend fun maybeAnnounce(status: IntakeStatus) {
        if (status.isComplete) {
            listener.onAnnouncement()
        }
    }
}
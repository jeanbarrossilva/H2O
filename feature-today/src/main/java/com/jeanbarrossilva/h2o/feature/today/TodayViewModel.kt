package com.jeanbarrossilva.h2o.feature.today

import androidx.lifecycle.ViewModel
import com.jeanbarrossilva.h2o.announcer.Announcer
import com.jeanbarrossilva.h2o.announcer.OnAnnouncementListener
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.model.extensions.intakestatus.orZero
import com.jeanbarrossilva.h2o.model.intake.IntakeLog
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.preferences.PreferenceManager
import com.jeanbarrossilva.h2o.preferences.preference.Preference

internal class TodayViewModel(
    private val preferenceManager: PreferenceManager,
    private val logger: Logger
): ViewModel() {
    suspend fun getIntakeStatus(): IntakeStatus {
        return preferenceManager.get(Preference.IntakeStatus).orZero
    }

    suspend fun getLogs(): List<IntakeLog> {
        return logger.getLogs()
    }

    fun doOnAnnouncement(listener: OnAnnouncementListener) {
        val announcer = Announcer(listener)
        preferenceManager.doOnChange(announcer)
    }
}
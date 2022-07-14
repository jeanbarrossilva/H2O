package com.jeanbarrossilva.h2o.announcer

import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.preferences.InMemoryPreferenceManager
import com.jeanbarrossilva.h2o.preferences.preference.Preference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class AnnouncerTest {
    private val preferenceManager = InMemoryPreferenceManager()

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `GIVEN a new status WHEN the goal has been achieved THEN it is announced`() {
        var hasBeenAnnounced = false
        preferenceManager.doOnChange(Announcer { hasBeenAnnounced = true })
        runTest { preferenceManager.set(Preference.IntakeStatus, IntakeStatus(Intake.sample)) }
        assertTrue(hasBeenAnnounced)
    }
}
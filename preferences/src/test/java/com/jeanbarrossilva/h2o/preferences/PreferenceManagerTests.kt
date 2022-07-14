package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.model.drinker.Drinker
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import com.jeanbarrossilva.h2o.preferences.preference.OnPreferenceChangeListener
import com.jeanbarrossilva.h2o.preferences.preference.Preference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@OptIn(ExperimentalCoroutinesApi::class)
class PreferenceManagerTests {
    private val preferenceManager = InMemoryPreferenceManager()

    @AfterTest
    fun tearDown() {
        runTest {
            preferenceManager.reset()
        }
    }

    @Test
    fun `GIVEN a drinker WHEN setting it THEN it's set`() {
        runTest {
            preferenceManager.set(Preference.Drinker, Drinker.sample)
            assertEquals(Drinker.sample, preferenceManager.get(Preference.Drinker))
        }
    }

    @Test
    fun `GIVEN an intake status WHEN setting it THEN it's set`() {
        runTest {
            preferenceManager.set(Preference.IntakeStatus, IntakeStatus.sample)
            assertEquals(IntakeStatus.sample, preferenceManager.get(Preference.IntakeStatus))
        }
    }

    @Test
    fun `GIVEN a property WHEN setting a new value for it THEN the listener is notified`() {
        runTest {
            var drinker: Drinker? = null
            preferenceManager.doOnChange(OnPreferenceChangeListener<Drinker, Preference<Drinker>> {
                _, value ->
                drinker = value
            })
            preferenceManager.set(Preference.Drinker, Drinker.sample)
            assertEquals(Drinker.sample, drinker)
        }
    }

    @Test
    fun `GIVEN a reset WHEN getting the properties that were previously set THEN they're null`() {
        runTest {
            preferenceManager.set(Preference.Drinker, Drinker.sample)
            preferenceManager.set(Preference.IntakeStatus, IntakeStatus.sample)
            preferenceManager.reset()
            assertNull(preferenceManager.get(Preference.Drinker))
            assertNull(preferenceManager.get(Preference.IntakeStatus))
        }
    }
}
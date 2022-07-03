package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.model.drinker.Drinker
import com.jeanbarrossilva.h2o.model.intake.IntakeStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.AfterTest
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
            preferenceManager.setDrinker(Drinker.sample)
            assertEquals(Drinker.sample, preferenceManager.getDrinker())
        }
    }

    @Test
    fun `GIVEN an intake status WHEN setting it THEN it's set`() {
        runTest {
            preferenceManager.setIntakeStatus(IntakeStatus.sample)
            assertEquals(IntakeStatus.sample, preferenceManager.getIntakeStatus())
        }
    }

    @Test
    fun `GIVEN a reset WHEN getting the properties that were previously set THEN they're null`() {
        runTest {
            preferenceManager.setDrinker(Drinker.sample)
            preferenceManager.setIntakeStatus(IntakeStatus.sample)
            preferenceManager.reset()
            assertNull(preferenceManager.getDrinker())
            assertNull(preferenceManager.getIntakeStatus())
        }
    }
}
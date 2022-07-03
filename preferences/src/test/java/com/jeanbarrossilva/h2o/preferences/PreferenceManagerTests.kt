package com.jeanbarrossilva.h2o.preferences

import com.jeanbarrossilva.h2o.drinker.Drinker
import com.jeanbarrossilva.h2o.model.intake.Intake
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
    fun `GIVEN an intake WHEN setting it THEN it's set`() {
        runTest {
            preferenceManager.setIntake(Intake.sample)
            assertEquals(Intake.sample, preferenceManager.getIntake())
        }
    }

    @Test
    fun `GIVEN an intake goal WHEN setting it THEN it's set`() {
        runTest {
            preferenceManager.setIntakeGoal(4_000)
            assertEquals(4_000, preferenceManager.getIntakeGoal())
        }
    }

    @Test
    fun `GIVEN a set property WHEN resetting THEN it's gone`() {
        runTest {
            preferenceManager.setIntakeGoal(3_500)
            preferenceManager.reset()
            assertNull(preferenceManager.getIntakeGoal())
        }
    }
}
package com.jeanbarrossilva.h2o.reminder

import com.jeanbarrossilva.h2o.reminder.fake.FakeClock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.hours

@OptIn(ExperimentalCoroutinesApi::class)
class ClockTests {
    @Test
    fun `GIVEN a time WHEN advancing the clock to it THEN it's been advanced`() {
        runTest {
            val clock = FakeClock(this)
            clock.jumpTo(LocalTime.of(9, 41))
            assertEquals(LocalTime.of(9, 41), clock.getCurrentTime())
        }
    }

    @Test
    fun `GIVEN a clock WHEN ticking THEN it ticks forwards`() {
        runTest {
            val clock = FakeClock(this)
            clock.jumpTo(LocalTime.of(8, 0))
            clock.start()
            advanceTimeBy(1.hours.inWholeMilliseconds)
            clock.stop()
            assertEquals(LocalTime.of(9, 0), clock.getCurrentTime())
        }
    }
}
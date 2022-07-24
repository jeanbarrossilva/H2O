package com.jeanbarrossilva.h2o.reminder

import com.jeanbarrossilva.h2o.reminder.fake.FakeClock
import com.jeanbarrossilva.h2o.reminder.fake.FakeScheduler
import com.jeanbarrossilva.h2o.reminder.frequency.dsl.every
import com.jeanbarrossilva.h2o.reminder.scheduler.schedule.Schedule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.hours

class SchedulerTests {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `GIVEN an active time range WHEN passing through it THEN it's being reminded according to the given frequency`() {
        runTest {
            val schedule = Schedule(LocalTime.of(9, 0)..LocalTime.of(21, 0), every(1.hours))
            val clock = FakeClock(this)
            val scheduler = FakeScheduler(this, clock, schedule)
            var reminderCount = 0

            scheduler.doOnReminder { reminderCount++ }
            scheduler.schedule()
            clock.jumpTo(LocalTime.of(21, 0))
            clock.stop()
            assertEquals(13, reminderCount)
        }
    }
}
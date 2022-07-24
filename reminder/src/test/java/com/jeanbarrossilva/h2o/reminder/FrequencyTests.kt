package com.jeanbarrossilva.h2o.reminder

import com.jeanbarrossilva.h2o.reminder.clock.Clock
import com.jeanbarrossilva.h2o.reminder.frequency.Frequency
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.time.Duration.Companion.nanoseconds

class FrequencyTests {
    @Test
    fun `GIVEN a threshold greater than clock's delay WHEN creating a repeated frequency with it THEN it throws`() {
        assertFailsWith<IllegalStateException> {
            Frequency.Repeatedly(Clock.delay + 1.nanoseconds)
        }
    }
}
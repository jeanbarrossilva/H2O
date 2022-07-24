package com.jeanbarrossilva.h2o.reminder

import com.jeanbarrossilva.h2o.reminder.extensions.localtime.minus
import com.jeanbarrossilva.h2o.reminder.extensions.localtime.orMin
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class LocalTimeExtensionsTest {
    @Test
    fun `GIVEN a nullable time WHEN calling orMin on it THEN the right one is given`() {
        assertEquals(LocalTime.MIN, (null as LocalTime?).orMin)
        assertEquals(LocalTime.of(23, 45), LocalTime.of(23, 45).orMin)
    }

    @Test
    fun `GIVEN two times WHEN subtracting them THEN the right duration in between is given`() {
        assertEquals(5.minutes, LocalTime.MIDNIGHT - LocalTime.of(0, 5))
        assertEquals(30.minutes, LocalTime.of(8, 0) - LocalTime.of(8, 30))
        assertEquals(2.hours, LocalTime.of(16, 0) - LocalTime.of(14, 0))
    }
}
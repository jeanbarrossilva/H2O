package com.jeanbarrossilva.h2o.reminder.frequency

import com.jeanbarrossilva.h2o.reminder.clock.Clock
import kotlin.time.Duration

sealed interface Frequency {
    data class Repeatedly internal constructor(val threshold: Duration): Frequency {
        init {
            check(threshold >= Clock.delay) {
                "Repetition threshold cannot be lower than ${Clock.delay}."
            }
        }
    }
}
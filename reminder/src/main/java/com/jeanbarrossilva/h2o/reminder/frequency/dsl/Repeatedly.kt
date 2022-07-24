package com.jeanbarrossilva.h2o.reminder.frequency.dsl

import com.jeanbarrossilva.h2o.reminder.frequency.Frequency
import kotlin.time.Duration

fun every(threshold: Duration): Frequency.Repeatedly {
    return Frequency.Repeatedly(threshold)
}
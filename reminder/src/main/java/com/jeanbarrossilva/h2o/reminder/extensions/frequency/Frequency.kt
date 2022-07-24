package com.jeanbarrossilva.h2o.reminder.extensions.frequency

import com.jeanbarrossilva.h2o.reminder.frequency.Frequency

internal val Frequency.duration
    get() = when (this) {
        is Frequency.Repeatedly -> threshold
    }
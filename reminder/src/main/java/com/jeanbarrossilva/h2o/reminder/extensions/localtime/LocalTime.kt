package com.jeanbarrossilva.h2o.reminder.extensions.localtime

import java.time.LocalTime
import kotlin.math.abs
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

internal val LocalTime?.orMin: LocalTime
    get() = this ?: LocalTime.of(0, 0)

internal operator fun LocalTime.inc(): LocalTime {
    return plusMinutes(1)
}

internal operator fun LocalTime.minus(other: LocalTime): Duration {
    val otherAsSecondOfDay = other.toSecondOfDay()
    val diff = toSecondOfDay().minus(otherAsSecondOfDay)

    return abs(diff).seconds
}
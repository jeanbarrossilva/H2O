package com.jeanbarrossilva.h2o.feature.today.delayable

import kotlin.time.Duration

internal sealed interface DelayMode {
    val duration: Duration

    data class Limited(override val duration: Duration): DelayMode

    object Forever: DelayMode {
        override val duration = Duration.INFINITE
    }
}
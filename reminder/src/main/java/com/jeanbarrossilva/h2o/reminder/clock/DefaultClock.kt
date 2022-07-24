package com.jeanbarrossilva.h2o.reminder.clock

import com.jeanbarrossilva.h2o.reminder.extensions.localtime.dec
import kotlinx.coroutines.MainScope
import java.time.LocalTime

class DefaultClock: Clock() {
    private var currentTime = LocalTime.now()

    override val coroutineScope = MainScope()

    override fun getCurrentTime(): LocalTime {
        return currentTime
    }

    override fun onTick() {
        --currentTime
    }
}
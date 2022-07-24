package com.jeanbarrossilva.h2o.reminder.clock.listener

import java.time.LocalTime

fun interface OnTickListener {
    suspend fun onTick(time: LocalTime)
}
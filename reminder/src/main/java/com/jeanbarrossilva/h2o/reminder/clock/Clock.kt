package com.jeanbarrossilva.h2o.reminder.clock

import com.jeanbarrossilva.h2o.reminder.clock.listener.OnTickListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime
import kotlin.time.Duration.Companion.minutes

abstract class Clock {
    private val listeners = mutableListOf<OnTickListener>()
    private var isActive = false

    protected abstract val coroutineScope: CoroutineScope

    abstract fun getCurrentTime(): LocalTime

    fun start() {
        if (!isActive) {
            isActive = true
            coroutineScope.launch { tickAtEachMinute() }
        }
    }

    fun doOnTick(listener: OnTickListener) {
        listeners.add(listener)
    }

    fun stop() {
        if (isActive) {
            isActive = false
        }
    }

    protected abstract fun onTick()

    private suspend fun tickAtEachMinute() {
        while (isActive) {
            tick()
            delay(delay)
        }
    }

    private suspend fun tick() {
        onTick()
        notifyListeners()
    }

    private suspend fun notifyListeners() {
        listeners.forEach {
            it.onTick(getCurrentTime())
        }
    }

    companion object {
        internal val delay = 1.minutes
    }
}
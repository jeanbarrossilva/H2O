package com.jeanbarrossilva.h2o.reminder.scheduler

import com.jeanbarrossilva.h2o.reminder.clock.Clock
import com.jeanbarrossilva.h2o.reminder.listener.OnReminderListener
import com.jeanbarrossilva.h2o.reminder.scheduler.schedule.Schedule
import kotlinx.coroutines.CoroutineScope
import java.time.LocalTime

abstract class Scheduler {
    private val listeners = mutableListOf<OnReminderListener>()

    protected abstract val coroutineScope: CoroutineScope
    protected abstract val clock: Clock
    protected abstract val schedule: Schedule

    protected var lastReminderTime: LocalTime? = null
        private set

    fun schedule() {
        clock.start()
        onSchedule()
    }

    fun doOnReminder(listener: OnReminderListener) {
        listeners.add(listener)
    }

    fun remind() {
        notifyListeners()
        lastReminderTime = clock.getCurrentTime()
    }

    protected open fun onSchedule() {
    }

    private fun notifyListeners() {
        listeners.forEach(OnReminderListener::onReminder)
    }
}
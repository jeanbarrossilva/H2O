package com.jeanbarrossilva.h2o.reminder.fake

import com.jeanbarrossilva.h2o.reminder.clock.Clock
import com.jeanbarrossilva.h2o.reminder.extensions.frequency.duration
import com.jeanbarrossilva.h2o.reminder.extensions.localtime.minus
import com.jeanbarrossilva.h2o.reminder.extensions.localtime.orMin
import com.jeanbarrossilva.h2o.reminder.scheduler.Scheduler
import com.jeanbarrossilva.h2o.reminder.scheduler.schedule.Schedule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalTime

class FakeScheduler(
    override val coroutineScope: CoroutineScope,
    override val clock: Clock,
    override val schedule: Schedule
) : Scheduler() {
    private val LocalTime.isInActiveRange
        get() = this in schedule.activeDayTimeRange
    private val LocalTime.isTimeToRemind
        get() = isInActiveRange && isFarEnoughFromLastReminder

    private val isFarEnoughFromLastReminder
        get() = lastReminderTime.orMin - clock.getCurrentTime() >= schedule.frequency.duration

    override fun onSchedule() {
        coroutineScope.launch {
            remindAtEachValidTick()
        }
    }

    private fun remindAtEachValidTick() {
        clock.doOnTick {
            if (it.isTimeToRemind) {
                remind()
            }
        }
    }
}
package com.jeanbarrossilva.h2o.reminder.scheduler.schedule

import com.jeanbarrossilva.h2o.reminder.frequency.Frequency
import java.time.LocalTime

data class Schedule(val activeDayTimeRange: ClosedRange<LocalTime>, val frequency: Frequency)
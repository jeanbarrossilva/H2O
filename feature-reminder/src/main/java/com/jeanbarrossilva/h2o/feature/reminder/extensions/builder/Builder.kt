package com.jeanbarrossilva.h2o.feature.reminder.extensions.builder

import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.Worker
import com.jeanbarrossilva.h2o.feature.reminder.ReminderWorker
import com.jeanbarrossilva.h2o.reminder.frequency.Frequency
import kotlin.time.toJavaDuration

@Suppress("FunctionName")
internal inline fun <reified T: Worker> PeriodicWorkRequestBuilder(frequency: Frequency.Repeatedly):
    PeriodicWorkRequest.Builder {
    val repeatInterval = frequency.threshold.toJavaDuration()
    return PeriodicWorkRequestBuilder<ReminderWorker>(repeatInterval)
}
package com.jeanbarrossilva.h2o.feature.reminder

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.jeanbarrossilva.h2o.reminder.scheduler.Scheduler

class ReminderWorkerFactory(private val scheduler: Scheduler): WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return if (workerClassName == ReminderWorker::class.qualifiedName) {
            ReminderWorker(appContext, workerParameters, scheduler)
        } else {
            null
        }
    }
}
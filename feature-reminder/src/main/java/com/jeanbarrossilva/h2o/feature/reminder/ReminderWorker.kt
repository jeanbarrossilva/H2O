package com.jeanbarrossilva.h2o.feature.reminder

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.jeanbarrossilva.h2o.reminder.scheduler.Scheduler

class ReminderWorker(context: Context, params: WorkerParameters, private val scheduler: Scheduler):
    Worker(context, params) {
    override fun doWork(): Result {
        scheduler.remind()
        return Result.success()
    }
}
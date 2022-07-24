package com.jeanbarrossilva.h2o.feature.reminder

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import androidx.work.WorkManager
import com.jeanbarrossilva.h2o.feature.reminder.extensions.builder.PeriodicWorkRequestBuilder
import com.jeanbarrossilva.h2o.reminder.clock.Clock
import com.jeanbarrossilva.h2o.reminder.frequency.Frequency
import com.jeanbarrossilva.h2o.reminder.scheduler.Scheduler
import com.jeanbarrossilva.h2o.reminder.scheduler.schedule.Schedule
import kotlinx.coroutines.MainScope
import java.lang.ref.WeakReference

class ReminderScheduler(
    override val clock: Clock,
    override val schedule: Schedule,
    private val boundary: ReminderBoundary,
    private val contextRef: WeakReference<Context>,
): Scheduler() {
    private val context
        get() = contextRef.get()

    override val coroutineScope = MainScope()

    constructor(
        clock: Clock,
        schedule: Schedule,
        boundary: ReminderBoundary,
        context: Context
    ): this(clock, schedule, boundary, WeakReference(context))

    init {
        doOnReminder(::sendNotification)
    }

    override fun onSchedule() {
        val workManager = context?.let { WorkManager.getInstance(it) }
        val requestBuilder = when (val frequency = schedule.frequency) {
            is Frequency.Repeatedly -> PeriodicWorkRequestBuilder<ReminderWorker>(frequency)
        }
        val request = requestBuilder.build()

        workManager?.enqueue(request)
    }

    private fun sendNotification() {
        context?.run {
            val notificationManager = getSystemService<NotificationManager>()
            val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_water_drop_48)
                .setContentTitle(getString(R.string.reminder_notification))
                .setContentIntent(boundary.navigateToLogger(this))
                .build()

            notificationManager?.notify(0, notification)
        }
    }

    companion object {
        const val CHANNEL_ID = "reminder"
    }
}
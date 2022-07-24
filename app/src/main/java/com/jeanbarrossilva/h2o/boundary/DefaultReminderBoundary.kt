package com.jeanbarrossilva.h2o.boundary

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.TaskStackBuilder
import com.jeanbarrossilva.h2o.feature.logger.LoggerActivity
import com.jeanbarrossilva.h2o.feature.reminder.ReminderBoundary

class DefaultReminderBoundary: ReminderBoundary {
    override fun navigateToLogger(context: Context): PendingIntent? {
        val intent = Intent(context, LoggerActivity::class.java)
        val requestCode = 0
        val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE

        return TaskStackBuilder.create(context)
            .addNextIntentWithParentStack(intent)
            .getPendingIntent(requestCode, flags)
    }
}
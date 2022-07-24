package com.jeanbarrossilva.h2o.feature.reminder

import android.app.PendingIntent
import android.content.Context

interface ReminderBoundary {
    fun navigateToLogger(context: Context): PendingIntent?
}
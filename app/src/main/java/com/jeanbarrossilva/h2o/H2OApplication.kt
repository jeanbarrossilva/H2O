package com.jeanbarrossilva.h2o

import android.app.Application
import android.app.NotificationManager
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService
import androidx.work.Configuration
import com.jeanbarrossilva.h2o.feature.history.historyModule
import com.jeanbarrossilva.h2o.feature.logger.loggerModule
import com.jeanbarrossilva.h2o.feature.preferences.preferencesModule
import com.jeanbarrossilva.h2o.feature.reminder.ReminderScheduler
import com.jeanbarrossilva.h2o.feature.reminder.ReminderWorkerFactory
import com.jeanbarrossilva.h2o.feature.today.todayModule
import com.jeanbarrossilva.h2o.injection.boundaryModule
import com.jeanbarrossilva.h2o.reminder.scheduler.Scheduler
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class H2OApplication: Application(), Configuration.Provider {
    private val scheduler by inject<Scheduler>()

    override fun onCreate() {
        super.onCreate()
        setUpKoin()
        setUpNotifications()
        setUpScheduler()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(ReminderWorkerFactory(scheduler))
            .build()
    }

    private fun setUpKoin() {
        startKoin {
            androidContext(this@H2OApplication)
            modules(h2oModule, boundaryModule)
            modules(historyModule, loggerModule, preferencesModule, todayModule)
        }
    }

    private fun setUpNotifications() {
        val notificationManager = getSystemService<NotificationManagerCompat>()
        val reminderChannel = NotificationChannelCompat.Builder(
            ReminderScheduler.CHANNEL_ID,
            NotificationManager.IMPORTANCE_HIGH
        )
            .setName(getString(R.string.notification_channel_reminder_name))
            .setDescription(getString(R.string.notification_channel_reminder_description))
            .build()

        notificationManager?.createNotificationChannel(reminderChannel)
    }

    private fun setUpScheduler() {
        scheduler.schedule()
    }
}
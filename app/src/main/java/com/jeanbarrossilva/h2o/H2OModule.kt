package com.jeanbarrossilva.h2o

import com.jeanbarrossilva.h2o.feature.reminder.ReminderScheduler
import com.jeanbarrossilva.h2o.logger.InMemoryLogger
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.logger.moment.DefaultMomentProvider
import com.jeanbarrossilva.h2o.logger.moment.MomentProvider
import com.jeanbarrossilva.h2o.preferences.InMemoryPreferenceManager
import com.jeanbarrossilva.h2o.preferences.PreferenceManager
import com.jeanbarrossilva.h2o.reminder.clock.Clock
import com.jeanbarrossilva.h2o.reminder.clock.DefaultClock
import com.jeanbarrossilva.h2o.reminder.frequency.dsl.every
import com.jeanbarrossilva.h2o.reminder.scheduler.Scheduler
import com.jeanbarrossilva.h2o.reminder.scheduler.schedule.Schedule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.time.LocalTime
import kotlin.time.Duration.Companion.minutes

val h2oModule = module {
    single<PreferenceManager> { InMemoryPreferenceManager() }
    single<MomentProvider> { DefaultMomentProvider() }
    single<Logger> { InMemoryLogger(momentProvider = get()) }
    single<Clock> { DefaultClock() }
    single { Schedule(LocalTime.of(8, 0)..LocalTime.of(21, 0), every(30.minutes)) }
    single<Scheduler> {
        ReminderScheduler(clock = get(), schedule = get(), boundary = get(), androidContext())
    }
}
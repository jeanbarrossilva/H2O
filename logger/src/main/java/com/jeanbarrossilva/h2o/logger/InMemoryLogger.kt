package com.jeanbarrossilva.h2o.logger

import com.jeanbarrossilva.h2o.logger.intake.Intake
import com.jeanbarrossilva.h2o.logger.intake.IntakeLog
import com.jeanbarrossilva.h2o.logger.time.MomentProvider

data class InMemoryLogger(private val momentProvider: MomentProvider): Logger {
    private val entries = mutableListOf<IntakeLog>()

    private val time
        get() = momentProvider.provide()

    override suspend fun getLogs(): List<IntakeLog> {
        return entries.toList()
    }

    override suspend fun getLogById(entryId: String): IntakeLog? {
        return entries.find {
            it.id == entryId
        }
    }

    override suspend fun log(intake: Intake): IntakeLog {
        return IntakeLog(time, intake).also {
            entries.add(it)
        }
    }

    override suspend fun remove(entry: IntakeLog) {
        entries.remove(entry)
    }
}
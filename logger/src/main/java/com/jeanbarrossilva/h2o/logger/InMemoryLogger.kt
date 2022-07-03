package com.jeanbarrossilva.h2o.logger

import com.jeanbarrossilva.h2o.logger.moment.MomentProvider
import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.model.intake.IntakeLog

data class InMemoryLogger(private val momentProvider: MomentProvider): Logger {
    private val entries = mutableListOf<IntakeLog>()

    private val moment
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
        return IntakeLog(moment, intake).also {
            entries.add(it)
        }
    }

    override suspend fun remove(entry: IntakeLog) {
        entries.remove(entry)
    }
}
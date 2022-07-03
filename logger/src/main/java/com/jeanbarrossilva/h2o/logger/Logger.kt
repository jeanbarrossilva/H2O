package com.jeanbarrossilva.h2o.logger

import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.model.intake.IntakeLog

interface Logger {
    suspend fun getLogs(): List<IntakeLog>

    suspend fun getLogById(entryId: String): IntakeLog?

    suspend fun log(intake: Intake): IntakeLog

    suspend fun remove(entry: IntakeLog)
}
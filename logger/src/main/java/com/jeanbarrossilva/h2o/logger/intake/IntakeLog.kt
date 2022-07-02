package com.jeanbarrossilva.h2o.logger.intake

import java.time.LocalDateTime
import java.util.UUID

data class IntakeLog internal constructor(val creationDate: LocalDateTime, val intake: Intake) {
    val id = UUID.randomUUID().toString()

    internal constructor(intake: Intake): this(LocalDateTime.now(), intake)

    companion object {
        val samples = Intake.samples.map { IntakeLog(it) }
    }
}
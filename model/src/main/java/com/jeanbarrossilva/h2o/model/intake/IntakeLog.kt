package com.jeanbarrossilva.h2o.model.intake

import java.time.LocalDateTime
import java.util.UUID

data class IntakeLog(val creationMoment: LocalDateTime, val intake: Intake) {
    val id = UUID.randomUUID().toString()

    constructor(intake: Intake): this(LocalDateTime.now(), intake)

    companion object {
        val samples = Intake.samples.map { IntakeLog(it) }
    }
}
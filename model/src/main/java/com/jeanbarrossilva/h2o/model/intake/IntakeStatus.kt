package com.jeanbarrossilva.h2o.model.intake

data class IntakeStatus(val current: Intake, val goal: Intake) {
    val isComplete = current >= goal

    constructor(intake: Intake): this(intake, intake)

    companion object {
        val zero = IntakeStatus(Intake.zero, Intake.zero)
        val sample = IntakeStatus(Intake(1_250), Intake.sample)
    }
}
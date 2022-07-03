package com.jeanbarrossilva.h2o.model.extensions.intakestatus

import com.jeanbarrossilva.h2o.model.intake.IntakeStatus

val IntakeStatus?.orZero
    get() = this ?: IntakeStatus.zero
val IntakeStatus.percentage
    get() = if (current > goal) 1f else current.milliliters.toFloat() / goal.milliliters.toFloat()
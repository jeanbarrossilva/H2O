package com.jeanbarrossilva.h2o.logger.extensions.intake

import com.jeanbarrossilva.h2o.logger.intake.Intake

val Intake?.orZero
    get() = this ?: Intake.zero
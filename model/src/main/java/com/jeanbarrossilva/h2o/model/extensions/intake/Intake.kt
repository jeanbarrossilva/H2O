package com.jeanbarrossilva.h2o.model.extensions.intake

import com.jeanbarrossilva.h2o.model.intake.Intake

val Intake?.orZero
    get() = this ?: Intake.zero
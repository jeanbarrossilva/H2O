package com.jeanbarrossilva.h2o.model.extensions

import com.jeanbarrossilva.h2o.model.intake.Intake

val Intake?.orZero
    get() = this ?: Intake.zero
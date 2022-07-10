package com.jeanbarrossilva.h2o.ui.today.extensions.intake

import android.content.Context
import com.jeanbarrossilva.h2o.model.intake.Intake
import com.jeanbarrossilva.h2o.ui.extensions.number.format
import com.jeanbarrossilva.h2o.ui.R

internal fun Intake.format(context: Context): String {
    return context.getString(R.string.intake, milliliters.format())
}
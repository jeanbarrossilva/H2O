package com.jeanbarrossilva.h2o.ui.today.extensions.number

import java.text.NumberFormat

internal val Number.formatted: String
    get() = NumberFormat.getInstance().format(this)
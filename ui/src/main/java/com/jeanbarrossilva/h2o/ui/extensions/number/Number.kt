package com.jeanbarrossilva.h2o.ui.extensions.number

import java.text.NumberFormat

fun Number.format(): String {
    return NumberFormat.getInstance().format(this)
}
package com.jeanbarrossilva.h2o.ui.extensions.localdatetime

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun LocalDateTime.format(): String {
    val locale = Locale.getDefault()
    val formatter = DateTimeFormatter.ofPattern("dd/MM", locale)

    return format(formatter)
}
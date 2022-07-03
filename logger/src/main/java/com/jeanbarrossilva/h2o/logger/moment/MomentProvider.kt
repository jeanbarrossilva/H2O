package com.jeanbarrossilva.h2o.logger.moment

import java.time.LocalDateTime

fun interface MomentProvider {
    fun provide(): LocalDateTime
}
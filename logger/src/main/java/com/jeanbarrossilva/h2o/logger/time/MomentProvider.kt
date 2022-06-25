package com.jeanbarrossilva.h2o.logger.time

import java.time.LocalDateTime

fun interface MomentProvider {
    fun provide(): LocalDateTime
}
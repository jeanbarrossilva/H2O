package com.jeanbarrossilva.h2o.logger.time

import java.time.LocalDateTime

object DefaultMomentProvider: MomentProvider {
    override fun provide(): LocalDateTime {
        return LocalDateTime.now()
    }
}
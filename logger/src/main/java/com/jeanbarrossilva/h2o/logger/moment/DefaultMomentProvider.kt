package com.jeanbarrossilva.h2o.logger.moment

import java.time.LocalDateTime

class DefaultMomentProvider: MomentProvider {
    override fun provide(): LocalDateTime {
        return LocalDateTime.now()
    }
}
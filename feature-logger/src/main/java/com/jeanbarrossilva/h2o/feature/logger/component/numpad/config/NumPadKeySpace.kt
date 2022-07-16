package com.jeanbarrossilva.h2o.feature.logger.component.numpad.config

sealed interface NumPadKeySpace {
    val factor: Int

    object Default: NumPadKeySpace {
        override val factor = 1
    }

    object Doubled: NumPadKeySpace {
        override val factor = 2
    }

    companion object {
        infix fun of(digit: Int): NumPadKeySpace {
            return if (digit == 0) Doubled else Default
        }
    }
}
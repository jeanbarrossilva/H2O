package com.jeanbarrossilva.h2o.model.drinker

sealed class Age {
    abstract val value: Int

    data class Child internal constructor(override val value: Int): Age()

    data class Adult internal constructor(override val value: Int): Age()

    data class Senior internal constructor(override val value: Int): Age()

    data class SeniorPlus internal constructor(override val value: Int): Age()

    companion object {
        infix fun of(value: Int): Age {
            return when (value) {
                in 1..17 -> Child(value)
                in 18..55 -> Adult(value)
                in 56..65 -> Senior(value)
                in 66..Int.MAX_VALUE -> SeniorPlus(value)
                else -> throw IllegalArgumentException("Value must be a non-zero positive number.")
            }
        }
    }
}
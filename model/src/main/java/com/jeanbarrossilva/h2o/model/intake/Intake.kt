package com.jeanbarrossilva.h2o.model.intake

data class Intake(val milliliters: Long): Comparable<Intake> {
    override fun compareTo(other: Intake): Int {
        return milliliters.compareTo(other.milliliters)
    }

    companion object {
        val zero = Intake(0)
        val samples = listOf(Intake(120), Intake(250), Intake(430), Intake(1_200), Intake(850))
        val sample = samples[3]
    }
}
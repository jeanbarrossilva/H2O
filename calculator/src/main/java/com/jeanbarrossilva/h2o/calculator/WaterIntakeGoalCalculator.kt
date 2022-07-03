package com.jeanbarrossilva.h2o.calculator

import com.jeanbarrossilva.h2o.model.drinker.Age
import com.jeanbarrossilva.h2o.model.drinker.Drinker

object WaterIntakeGoalCalculator {
    fun calculate(drinker: Drinker): Long {
        val factor = getFactorOf(drinker.age)
        return drinker.weightInKilograms.toLong() * factor.toLong()
    }

    private fun getFactorOf(age: Age): Int {
        return when (age) {
            is Age.Child -> 40
            is Age.Adult -> 35
            is Age.Senior -> 30
            is Age.SeniorPlus -> 25
        }
    }
}
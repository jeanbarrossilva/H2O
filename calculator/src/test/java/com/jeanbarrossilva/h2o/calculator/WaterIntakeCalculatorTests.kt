package com.jeanbarrossilva.h2o.calculator

import com.jeanbarrossilva.h2o.model.drinker.Age
import com.jeanbarrossilva.h2o.model.drinker.Drinker
import com.jeanbarrossilva.h2o.model.intake.Intake
import kotlin.test.Test
import kotlin.test.assertEquals

class WaterIntakeCalculatorTests {
    @Test
    fun `GIVEN a weight of 40 kg and an age of 14 WHEN calculating the goal THEN it's 1,600 mL`() {
        val drinker = Drinker("Marcelo", Age of 14, weightInKilograms = 40)
        assertEquals(Intake(1_600), WaterIntakeGoalCalculator.calculate(drinker))
    }

    @Test
    fun `GIVEN a weight of 120 kg and an age of 35 WHEN calculating the goal THEN it's 4,200 mL`() {
        val drinker = Drinker("Carlos", Age of 35, weightInKilograms = 120)
        assertEquals(Intake(4_200), WaterIntakeGoalCalculator.calculate(drinker))
    }
}
package com.jeanbarrossilva.h2o.calculator.drinker

import java.util.UUID

data class Drinker(val age: Age, val weightInKilograms: Int) {
    val id = UUID.randomUUID().toString()
}
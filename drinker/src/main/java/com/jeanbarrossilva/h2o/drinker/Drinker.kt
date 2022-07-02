package com.jeanbarrossilva.h2o.drinker

import java.util.UUID

data class Drinker(val name: String, val age: Age, val weightInKilograms: Int) {
    val id = UUID.randomUUID().toString()

    companion object {
        val sample = Drinker(name = "Jean", Age of 18, weightInKilograms = 45)
    }
}
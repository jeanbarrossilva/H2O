package com.jeanbarrossilva.h2o.drinker

import java.util.UUID

data class Drinker(val age: Age, val weightInKilograms: Int) {
    val id = UUID.randomUUID().toString()
}
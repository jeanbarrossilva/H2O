package com.jeanbarrossilva.h2o.feature.today.extensions.stateflow.mutablestateflow

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KProperty

operator fun <T> MutableStateFlow<T>.setValue(thisRef: Any, property: KProperty<*>, value: T) {
    this.value = value
}
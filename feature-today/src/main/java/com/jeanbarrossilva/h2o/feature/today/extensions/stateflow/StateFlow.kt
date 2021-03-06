package com.jeanbarrossilva.h2o.feature.today.extensions.stateflow

import kotlinx.coroutines.flow.StateFlow
import kotlin.reflect.KProperty

operator fun <T> StateFlow<T>.getValue(thisRef: Any?, property: KProperty<*>): T {
    return value
}
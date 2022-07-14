package com.jeanbarrossilva.h2o.feature.today.delayable

import com.jeanbarrossilva.h2o.feature.today.extensions.stateflow.getValue
import com.jeanbarrossilva.h2o.feature.today.extensions.stateflow.mutablestateflow.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class Delayable(val mode: DelayMode) {
    private val activenessFlow = MutableStateFlow(false)
    private var isActive by activenessFlow

    fun getActivenessFlow(): Flow<Boolean> {
        return activenessFlow.asStateFlow()
    }

    suspend fun delay() {
        isActive = true
        delay(mode.duration)
        isActive = false
    }
}
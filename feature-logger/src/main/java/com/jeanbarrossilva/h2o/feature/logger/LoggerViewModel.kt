package com.jeanbarrossilva.h2o.feature.logger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeanbarrossilva.h2o.logger.Logger
import com.jeanbarrossilva.h2o.model.intake.Intake
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class LoggerViewModel(private val logger: Logger): ViewModel() {
    private val intakeFlow = MutableStateFlow(Intake.zero)
    private val onLogListeners = mutableListOf<() -> Unit>()

    fun getIntakeFlow(): StateFlow<Intake> {
        return intakeFlow.asStateFlow()
    }

    fun setIntake(intake: Intake) {
        viewModelScope.launch {
            intakeFlow.emit(intake)
        }
    }

    fun log() {
        viewModelScope.launch { logger.log(intakeFlow.value) }
        notifyOnLogListeners()
    }

    fun doOnLog(listener: () -> Unit) {
        onLogListeners.add(listener)
    }

    private fun notifyOnLogListeners() {
        onLogListeners.forEach {
            it.invoke()
        }
    }
}
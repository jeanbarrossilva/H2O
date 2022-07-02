package com.jeanbarrossilva.h2o.ui.extensions.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.full.primaryConstructor

fun viewModelFactoryOf(vararg args: Any?): ViewModelProvider.Factory {
    return object: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.kotlin.primaryConstructor!!.call(*args)
        }
    }
}
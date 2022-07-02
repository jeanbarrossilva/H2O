package com.jeanbarrossilva.h2o.ui.extensions.kclass

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T: ViewBinding> KClass<T>.inflate(inflater: LayoutInflater): T? {
    return java.getMethod("inflate").invoke(null, inflater) as T?
}
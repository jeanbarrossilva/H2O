package com.jeanbarrossilva.h2o.ui.extensions.viewbindingholder

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.jeanbarrossilva.h2o.ui.binding.ViewBinder

@Suppress("UNCHECKED_CAST")
inline fun <reified T: ViewBinding> ViewBinder<T>.bind(activity: AppCompatActivity): View? {
    return bind(T::class, activity)
}
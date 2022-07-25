package com.jeanbarrossilva.h2o.ui.extensions.bindable

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.jeanbarrossilva.h2o.ui.binding.Bindable

inline fun <reified T: ViewBinding> Bindable<T>.bind(activity: AppCompatActivity): View? {
    return bind(T::class, activity)
}
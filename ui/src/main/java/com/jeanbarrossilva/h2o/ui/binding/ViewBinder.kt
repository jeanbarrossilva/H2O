package com.jeanbarrossilva.h2o.ui.binding

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

interface ViewBinder<T: ViewBinding> {
    val binding: T?

    fun bind(viewBindingClass: KClass<T>, activity: AppCompatActivity): View?
}
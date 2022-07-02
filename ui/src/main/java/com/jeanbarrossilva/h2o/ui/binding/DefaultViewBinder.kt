package com.jeanbarrossilva.h2o.ui.binding

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.jeanbarrossilva.h2o.ui.extensions.kclass.inflate
import kotlin.reflect.KClass

class DefaultViewBinder<T: ViewBinding>: ViewBinder<T>, DefaultLifecycleObserver {
    private var lifecycle: Lifecycle? = null

    override var binding: T? = null
        private set

    override fun onDestroy(owner: LifecycleOwner) {
        lifecycle?.removeObserver(this)
        lifecycle = null
        binding = null
    }

    override fun bind(viewBindingClass: KClass<T>, activity: AppCompatActivity): View? {
        setUpLifecycle(activity)
        binding = viewBindingClass.inflate(activity.layoutInflater)
        return binding?.root
    }

    private fun setUpLifecycle(activity: AppCompatActivity) {
        lifecycle = activity.lifecycle
        lifecycle?.addObserver(this)
    }
}
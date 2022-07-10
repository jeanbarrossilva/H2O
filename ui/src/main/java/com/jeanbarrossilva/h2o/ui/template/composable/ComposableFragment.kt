package com.jeanbarrossilva.h2o.ui.template.composable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import com.jeanbarrossilva.h2o.ui.extensions.fragment.compose
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

abstract class ComposableFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return compose {
            H2OTheme {
                Content()
            }
        }
    }

    @Composable
    abstract fun Content()
}
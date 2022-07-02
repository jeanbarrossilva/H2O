package com.jeanbarrossilva.h2o.ui.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

abstract class ComposableFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return context?.let {
            ComposeView(it).apply {
                setContent {
                    H2OTheme {
                        this@ComposableFragment.Content()
                    }
                }
            }
        }
    }

    @Composable
    abstract fun Content()
}
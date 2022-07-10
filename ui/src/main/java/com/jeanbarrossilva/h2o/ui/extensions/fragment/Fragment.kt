package com.jeanbarrossilva.h2o.ui.extensions.fragment

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

fun Fragment.compose(content: @Composable () -> Unit): ComposeView? {
    return context?.let {
        ComposeView(it).apply {
            setContent(content)
        }
    }
}
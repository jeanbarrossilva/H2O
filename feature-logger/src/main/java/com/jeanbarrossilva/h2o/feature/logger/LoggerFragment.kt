package com.jeanbarrossilva.h2o.feature.logger

import android.os.Bundle
import androidx.compose.runtime.Composable
import com.jeanbarrossilva.h2o.ui.template.composable.ComposableFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class LoggerFragment: ComposableFragment() {
    private val viewModel by viewModel<LoggerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finishOnLog()
    }

    @Composable
    override fun Content() {
        Logger(viewModel)
    }

    private fun finishOnLog() {
        viewModel.doOnLog {
            activity?.finish()
        }
    }
}
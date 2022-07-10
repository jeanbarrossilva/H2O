package com.jeanbarrossilva.h2o.ui.history

import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import com.jeanbarrossilva.h2o.ui.template.composable.ComposableBottomSheetFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment private constructor(): ComposableBottomSheetFragment() {
    private val viewModel by viewModel<HistoryViewModel>()

    @Composable
    override fun Content() {
        History(viewModel)
    }

    companion object {
        fun show(activity: FragmentActivity?) {
            val label: String? = null
            activity?.supportFragmentManager?.let { HistoryFragment().show(it, label) }
        }
    }
}
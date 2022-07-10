package com.jeanbarrossilva.h2o.ui.template.composable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jeanbarrossilva.h2o.ui.R
import com.jeanbarrossilva.h2o.ui.component.sheet.Sheet
import com.jeanbarrossilva.h2o.ui.extensions.fragment.compose
import com.jeanbarrossilva.h2o.ui.theme.H2OTheme

abstract class ComposableBottomSheetFragment: BottomSheetDialogFragment() {
    @Composable
    abstract fun Content()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return compose {
            H2OTheme {
                Sheet {
                    Content()
                }
            }
        }
    }

    override fun getTheme(): Int {
        return R.style.Theme_H2O_Component_BottomSheetDialog
    }
}
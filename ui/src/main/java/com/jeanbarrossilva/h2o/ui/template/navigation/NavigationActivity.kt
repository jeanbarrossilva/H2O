package com.jeanbarrossilva.h2o.ui.template.navigation

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.jeanbarrossilva.h2o.ui.R
import com.jeanbarrossilva.h2o.ui.binding.Bindable
import com.jeanbarrossilva.h2o.ui.binding.DefaultBindable
import com.jeanbarrossilva.h2o.ui.databinding.ActivityNavigationBinding
import com.jeanbarrossilva.h2o.ui.extensions.bindable.bind

open class NavigationActivity(
    @NavigationRes private val navGraphResId: Int,
    private val isToolbarShown: Boolean = true
): AppCompatActivity(), Bindable<ActivityNavigationBinding> by DefaultBindable() {
    private val navController
        get() = navHostFragment.navController
    private val navHostFragment
        get() = supportFragmentManager.findFragmentById(R.id.container_view) as NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
        setUpNavigation()
    }

    override fun onNavigateUp(): Boolean {
        navigateUp()
        return true
    }

    private fun setUpView() {
        bind(this)
        setContentView(binding?.root)
        setUpToolbar()
    }

    private fun setUpToolbar() {
        if (isToolbarShown) {
            binding?.toolbar?.isVisible = true
            binding?.toolbar?.setupWithNavController(navController)
        }
    }

    private fun setUpNavigation() {
        navController.setGraph(navGraphResId)
    }

    private fun navigateUp() {
        if (cannotNavigateUp()) {
            onBackPressed()
        }
    }

    private fun cannotNavigateUp(): Boolean {
        return !navController.navigateUp() || !super.onNavigateUp()
    }
}
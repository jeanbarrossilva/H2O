package com.jeanbarrossilva.h2o.ui.template

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.jeanbarrossilva.h2o.ui.R
import com.jeanbarrossilva.h2o.ui.binding.DefaultViewBinder
import com.jeanbarrossilva.h2o.ui.binding.ViewBinder
import com.jeanbarrossilva.h2o.ui.databinding.ActivityNavigationBinding

open class NavigationActivity(@NavigationRes private val navGraphResId: Int):
    AppCompatActivity(R.layout.activity_navigation),
    ViewBinder<ActivityNavigationBinding> by DefaultViewBinder() {
    private val navController
        get() = navHostFragment.navController
    private val navHostFragment
        get() = supportFragmentManager.findFragmentById(R.id.container_view) as NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController.setGraph(navGraphResId)
    }

    override fun onNavigateUp(): Boolean {
        navigateUp()
        return true
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
package com.gbjm.core.ui

import android.os.Bundle
import androidx.navigation.findNavController
import com.gbjm.core.R
import com.gbjm.navigation.NavigationFlow
import com.gbjm.navigation.Navigator
import com.gbjm.navigation.ToFlowNavigable
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), ToFlowNavigable {
    private val navigator: Navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.navController = findNavController(R.id.mainHostFragment)
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }
}
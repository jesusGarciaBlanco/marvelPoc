package com.gbjm.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.gbjm.core.R
import com.gbjm.navigation.NavigationFlow
import com.gbjm.navigation.ToFlowNavigable

class StartFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.initiateAppBtn)
        button.setOnClickListener {
            (requireActivity() as ToFlowNavigable).navigateToFlow(NavigationFlow.CharactersFlow)
        }
    }
}
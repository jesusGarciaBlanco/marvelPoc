package com.gbjm.navigation

import androidx.navigation.NavController

class Navigator {
    lateinit var navController: NavController

    // navigate on main thread or nav component crashes sometimes
    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        NavigationFlow.CharactersFlow -> navController.navigate(MainNavGraphDirections.actionGlobalCharactersFlow())
        is NavigationFlow.DetailsFlow -> navController.navigate(MainNavGraphDirections.actionGlobalCharacterDetailFlow(navigationFlow.characterId))
    }
}
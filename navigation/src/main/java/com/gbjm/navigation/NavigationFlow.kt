package com.gbjm.navigation

sealed class NavigationFlow {
    object CharactersFlow : NavigationFlow()
    class DetailsFlow(val characterId: Int) : NavigationFlow()
}
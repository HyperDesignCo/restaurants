package com.heyperdesign.restaurants.common.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

sealed interface IEntryGraph {
    @Serializable
    data object RootGraph : IGraph

    @Serializable
    data object Splash : IDestination
}

fun NavGraphBuilder.buildNavEntryGraph() {
    navigation<IEntryGraph.RootGraph>(startDestination = IEntryGraph.Splash) {

    }
}
package com.heyperdesign.restaurants.common.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.heyperdesign.restaurants.feature.entry.onboarding.ui.view.OnBoardingScreen
import kotlinx.serialization.Serializable

sealed interface IEntryGraph {
    @Serializable
    data object RootGraph : IGraph

    @Serializable
    data object Splash : IDestination

    @Serializable
    data object OnBoarding : IDestination
}

fun NavGraphBuilder.buildNavEntryGraph() {
    navigation<IEntryGraph.RootGraph>(startDestination = IEntryGraph.OnBoarding) {
        composable<IEntryGraph.OnBoarding> { OnBoardingScreen() }
    }
}
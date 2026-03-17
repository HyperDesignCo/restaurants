package com.heyperdesign.restaurants.common.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.heyperdesign.restaurants.feature.authentication.login.ui.view.LoginScreen
import com.heyperdesign.restaurants.feature.authentication.signup.ui.view.SignupScreen
import com.heyperdesign.restaurants.feature.entry.onboarding.ui.view.OnBoardingScreen
import kotlinx.serialization.Serializable

sealed interface IEntryGraph {
    @Serializable
    data object RootGraph : IGraph

    @Serializable
    data object Splash : IDestination

    @Serializable
    data object OnBoarding : IDestination

    @Serializable
    data object Login : IDestination

    @Serializable
    data object Signup : IDestination
}

fun NavGraphBuilder.buildNavEntryGraph() {
    navigation<IEntryGraph.RootGraph>(startDestination = IEntryGraph.OnBoarding) {
        composable<IEntryGraph.OnBoarding> { OnBoardingScreen() }
        composable<IEntryGraph.Login> { LoginScreen() }
        composable<IEntryGraph.Signup> { SignupScreen() }
    }
}
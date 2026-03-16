package com.heyperdesign.restaurants.common.di

import com.heyperdesign.restaurants.feature.authentication.base.di.authenticationModule
import com.heyperdesign.restaurants.feature.authentication.login.di.loginModule
import com.heyperdesign.restaurants.feature.entry.onboarding.di.onBoardingModule
import com.heyperdesign.restaurants.services.user.di.userModule
import org.koin.dsl.module

val featuresModule = module {
    includes(
        onBoardingModule,
        userModule,
        authenticationModule,
        loginModule,
    )
}
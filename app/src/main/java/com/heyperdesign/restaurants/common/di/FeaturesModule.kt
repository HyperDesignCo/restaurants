package com.heyperdesign.restaurants.common.di

import com.heyperdesign.restaurants.feature.entry.onboarding.di.onBoardingModule
import org.koin.dsl.module

val featuresModule = module {
    includes(onBoardingModule)
}
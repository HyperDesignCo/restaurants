package com.heyperdesign.restaurants.feature.entry.onboarding.di

import com.heyperdesign.restaurants.feature.entry.onboarding.ui.viewmodel.OnBoardingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val onBoardingModule = module {
    viewModelOf(::OnBoardingViewModel)
}
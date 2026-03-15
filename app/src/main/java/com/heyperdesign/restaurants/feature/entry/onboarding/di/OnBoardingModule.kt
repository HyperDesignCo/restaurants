package com.heyperdesign.restaurants.feature.entry.onboarding.di

import com.heyperdesign.restaurants.feature.entry.onboarding.data.repository.OnBoardingRepository
import com.heyperdesign.restaurants.feature.entry.onboarding.data.repository.local.OnBoardingLocalDataSourceProvider
import com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository.IOnBoardingRepository
import com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository.local.IOnboardingLocalDataSourceProvider
import com.heyperdesign.restaurants.feature.entry.onboarding.domain.usecase.SaveOnBoardingUC
import com.heyperdesign.restaurants.feature.entry.onboarding.ui.viewmodel.OnBoardingViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val onBoardingModule = module {
    singleOf(::OnBoardingLocalDataSourceProvider) bind IOnboardingLocalDataSourceProvider::class
    singleOf(::OnBoardingRepository) bind IOnBoardingRepository::class
    factoryOf(::SaveOnBoardingUC)
    viewModelOf(::OnBoardingViewModel)
}
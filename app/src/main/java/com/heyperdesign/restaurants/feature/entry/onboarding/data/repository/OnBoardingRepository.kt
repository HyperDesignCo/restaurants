package com.heyperdesign.restaurants.feature.entry.onboarding.data.repository

import com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository.IOnBoardingRepository
import com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository.local.IOnboardingLocalDataSourceProvider

class OnBoardingRepository(private val local: IOnboardingLocalDataSourceProvider) : IOnBoardingRepository {
    override suspend fun saveOnBoarding() = local.saveOnBoarding()
}
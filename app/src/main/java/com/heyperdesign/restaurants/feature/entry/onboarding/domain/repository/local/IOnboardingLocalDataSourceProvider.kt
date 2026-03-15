package com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository.local

interface IOnboardingLocalDataSourceProvider{
    suspend fun saveOnBoarding()
    suspend fun getOnBoarding(): Boolean
}
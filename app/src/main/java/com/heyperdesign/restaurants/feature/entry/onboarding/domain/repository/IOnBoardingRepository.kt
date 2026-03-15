package com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository

interface IOnBoardingRepository {
    suspend fun saveOnBoarding()
}
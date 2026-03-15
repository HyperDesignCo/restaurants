package com.heyperdesign.restaurants.feature.entry.onboarding.data.repository.local

import com.heyperdesign.restaurants.common.data.repository.local.LocalDataSourceEnum
import com.heyperdesign.restaurants.common.domain.local.ILocalDataSourceProvider
import com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository.local.IOnboardingLocalDataSourceProvider

class OnBoardingLocalDataSourceProvider(private val provider: ILocalDataSourceProvider) :
    IOnboardingLocalDataSourceProvider {
    override suspend fun saveOnBoarding() =
        provider.save(key = LocalDataSourceEnum.IS_ONBOARDING, value = true, type = Boolean::class.java)

    override suspend fun getOnBoarding(): Boolean = provider.read(
        key = LocalDataSourceEnum.IS_ONBOARDING,
        defaultValue = false,
        type = Boolean::class.java
    )
}
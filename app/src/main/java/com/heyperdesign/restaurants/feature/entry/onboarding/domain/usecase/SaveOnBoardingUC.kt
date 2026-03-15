package com.heyperdesign.restaurants.feature.entry.onboarding.domain.usecase

import com.heyperdesign.restaurants.common.domain.Resource
import com.heyperdesign.restaurants.common.domain.usecase.BaseUseCase
import com.heyperdesign.restaurants.feature.entry.onboarding.domain.repository.IOnBoardingRepository
import kotlinx.coroutines.flow.Flow

class SaveOnBoardingUC(val repository: IOnBoardingRepository) : BaseUseCase<Flow<Resource<Unit>>, Unit>() {
    override suspend fun invoke(body: Unit) = flowExecute {
        repository.saveOnBoarding()
    }
}
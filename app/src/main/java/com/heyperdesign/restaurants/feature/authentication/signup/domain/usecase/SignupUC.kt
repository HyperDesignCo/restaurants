package com.heyperdesign.restaurants.feature.authentication.signup.domain.usecase

import com.heyperdesign.restaurants.common.data.exception.RestaurantsException
import com.heyperdesign.restaurants.common.domain.Resource
import com.heyperdesign.restaurants.common.domain.usecase.BaseUseCase
import com.heyperdesign.restaurants.feature.authentication.base.domain.model.Authentication
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.IAuthenticationRepository
import com.heyperdesign.restaurants.feature.authentication.signup.domain.model.request.SignupRequest
import kotlinx.coroutines.flow.Flow

class SignupUC(private val repository: IAuthenticationRepository) :
    BaseUseCase<Flow<Resource<Authentication>>, SignupRequest>() {
    override suspend fun invoke(body: SignupRequest): Flow<Resource<Authentication>> = flowExecute {
        val errors = body.validateFields()
        if (errors.isNotEmpty()) throw RestaurantsException.Local.RequestValidation(errors = errors)
        repository.signup(body)
    }
}
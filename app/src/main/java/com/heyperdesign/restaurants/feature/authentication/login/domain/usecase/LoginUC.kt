package com.heyperdesign.restaurants.feature.authentication.login.domain.usecase

import com.heyperdesign.restaurants.common.data.exception.RestaurantsException
import com.heyperdesign.restaurants.common.domain.Resource
import com.heyperdesign.restaurants.common.domain.usecase.BaseUseCase
import com.heyperdesign.restaurants.feature.authentication.base.domain.model.Authentication
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.IAuthenticationRepository
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest
import kotlinx.coroutines.flow.Flow

class LoginUC (private val repository: IAuthenticationRepository) :
BaseUseCase<Flow<Resource<Authentication>>, LoginRequest>() {
    override suspend fun invoke(body: LoginRequest): Flow<Resource<Authentication>> = flowExecute {
        val errors = body.validateFields()
        if (errors.isNotEmpty()) throw RestaurantsException.Local.RequestValidation(errors = errors)
        repository.login(body)
    }
}
package com.heyperdesign.restaurants.feature.authentication.base.domain.repository.remote

import com.heyperdesign.restaurants.feature.authentication.base.data.model.dto.AuthenticationDto
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest

interface IAuthenticationRemoteDataSource {
    suspend fun login(request : LoginRequest) : AuthenticationDto
}
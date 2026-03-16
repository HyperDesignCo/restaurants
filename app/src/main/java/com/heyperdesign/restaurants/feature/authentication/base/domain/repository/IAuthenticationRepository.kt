package com.heyperdesign.restaurants.feature.authentication.base.domain.repository

import com.heyperdesign.restaurants.feature.authentication.base.domain.model.Authentication
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest

interface IAuthenticationRepository {
    suspend fun login(request: LoginRequest) : Authentication
}
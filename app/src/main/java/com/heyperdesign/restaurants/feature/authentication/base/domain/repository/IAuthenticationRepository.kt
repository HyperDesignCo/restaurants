package com.heyperdesign.restaurants.feature.authentication.base.domain.repository

import com.heyperdesign.restaurants.feature.authentication.base.domain.model.Authentication
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest
import com.heyperdesign.restaurants.feature.authentication.signup.domain.model.request.SignupRequest

interface IAuthenticationRepository {
    suspend fun login(request: LoginRequest) : Authentication
    suspend fun signup(request: SignupRequest) : Authentication
}
package com.heyperdesign.restaurants.feature.authentication.base.data.repository.remote

import com.heyperdesign.restaurants.common.domain.remote.IRemoteDataSourceProvider
import com.heyperdesign.restaurants.feature.authentication.base.data.model.dto.AuthenticationDto
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.remote.IAuthenticationRemoteDataSource
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest
import com.heyperdesign.restaurants.feature.authentication.signup.domain.model.request.SignupRequest

class AuthenticationRemoteDataSource(private val provider: IRemoteDataSourceProvider) :
    IAuthenticationRemoteDataSource {
    override suspend fun login(request: LoginRequest): AuthenticationDto = provider.post(
        endpoint = LOGIN_ENDPOINT,
        requestBody = request,
        serializer = AuthenticationDto.serializer()
    )

    override suspend fun signup(request: SignupRequest): AuthenticationDto = provider.post(
        endpoint = SIGNUP_ENDPOINT,
        requestBody = request,
        serializer = AuthenticationDto.serializer()
    )

    companion object {
        private const val LOGIN_ENDPOINT = "login"
        private const val SIGNUP_ENDPOINT = "register"
    }
}
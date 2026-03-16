package com.heyperdesign.restaurants.feature.authentication.base.data.repository.remote

import com.heyperdesign.restaurants.common.domain.remote.IRemoteDataSourceProvider
import com.heyperdesign.restaurants.feature.authentication.base.data.model.dto.AuthenticationDto
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.remote.IAuthenticationRemoteDataSource
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest

class AuthenticationRemoteDataSource(private val provider: IRemoteDataSourceProvider) :
    IAuthenticationRemoteDataSource {
    override suspend fun login(request: LoginRequest): AuthenticationDto = provider.post(
        endpoint = LOGIN_ENDPOINT,
        requestBody = request,
        serializer = AuthenticationDto.serializer()
    )

    companion object {
        private const val LOGIN_ENDPOINT = "login"
    }
}
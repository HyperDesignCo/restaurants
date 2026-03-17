package com.heyperdesign.restaurants.feature.authentication.base.data.repository

import com.heyperdesign.restaurants.feature.authentication.base.data.mapper.AuthenticationMapper
import com.heyperdesign.restaurants.feature.authentication.base.domain.model.Authentication
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.IAuthenticationRepository
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.remote.IAuthenticationRemoteDataSource
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest
import com.heyperdesign.restaurants.feature.authentication.signup.domain.model.request.SignupRequest
import com.heyperdesign.restaurants.services.user.data.mapper.UserMapper
import com.heyperdesign.restaurants.services.user.data.model.dto.UserDto
import com.heyperdesign.restaurants.services.user.domain.repository.local.IUserLocalDataSource

class AuthenticationRepository(val remote: IAuthenticationRemoteDataSource, val local: IUserLocalDataSource) :
    IAuthenticationRepository {
    override suspend fun login(request: LoginRequest): Authentication {
        val result = remote.login(request)
        local.saveUser(user = UserMapper.dtoToEntity(model = result.user ?: UserDto()))
        local.saveToken(token = result.accessToken.orEmpty())
        local.saveIsAuthenticated(true)
        local.savePassword(request.password)
        return AuthenticationMapper.dtoToDomain(model = result)
    }

    override suspend fun signup(request: SignupRequest): Authentication {
        val result = remote.signup(request)
        local.saveUser(user = UserMapper.dtoToEntity(model = result.user ?: UserDto()))
        local.saveToken(token = result.accessToken.orEmpty())
        local.saveIsAuthenticated(true)
        local.savePassword(request.password)
        return AuthenticationMapper.dtoToDomain(model = result)
    }
}
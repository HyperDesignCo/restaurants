package com.heyperdesign.restaurants.services.user.data.repository

import com.heyperdesign.restaurants.services.user.data.mapper.UserMapper
import com.heyperdesign.restaurants.services.user.domain.model.User
import com.heyperdesign.restaurants.services.user.domain.repository.IUserRepository
import com.heyperdesign.restaurants.services.user.domain.repository.local.IUserLocalDataSource

class UserRepository(private val local: IUserLocalDataSource) : IUserRepository {
    override suspend fun saveIsAuthenticated(isAuthenticated: Boolean) =
        local.saveIsAuthenticated(isAuthenticated)

    override suspend fun getIsAuthenticated(): Boolean =
        local.getIsAuthenticated()

    override suspend fun getUser(): User = UserMapper.entityToDomain(local.getUser())

    override suspend fun deleteToken() = local.deleteToken()

    override suspend fun deleteUser() = local.deleteUser()

    override suspend fun deleteRememberMe() = local.deleteRememberMe()

    override suspend fun deleteIsAuthenticated() = local.deleteIsAuthenticated()

    override suspend fun getPassword(): String = local.getPassword()

    override suspend fun saveToken(token: String) = local.saveToken(token)

    override suspend fun getToken(): String = local.getToken()
}
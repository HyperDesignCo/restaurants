package com.heyperdesign.restaurants.services.user.domain.repository

import com.heyperdesign.restaurants.services.user.domain.model.User

interface IUserRepository {
    suspend fun saveIsAuthenticated(isAuthenticated: Boolean)
    suspend fun getIsAuthenticated(): Boolean
    suspend fun getUser(): User
    suspend fun deleteToken()
    suspend fun deleteUser()
    suspend fun deleteRememberMe()
    suspend fun deleteIsAuthenticated()
    suspend fun getPassword(): String
    suspend fun saveToken(token: String)
    suspend fun getToken(): String
}
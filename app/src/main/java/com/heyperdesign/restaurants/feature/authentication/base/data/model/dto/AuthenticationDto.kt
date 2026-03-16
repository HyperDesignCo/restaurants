package com.heyperdesign.restaurants.feature.authentication.base.data.model.dto

import com.heyperdesign.restaurants.services.user.data.model.dto.UserDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationDto(
    @SerialName("access_token")
    val accessToken: String?= null,
    @SerialName("message")
    val message: String?= null,
    @SerialName("token_type")
    val tokenType: String?= null,
    @SerialName("user")
    val user: UserDto?= null
)
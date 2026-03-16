package com.heyperdesign.restaurants.services.user.data.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    val id: String = "",
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val image: String = "",
    val balance: String = "",
    val authenticated: String = "",
)
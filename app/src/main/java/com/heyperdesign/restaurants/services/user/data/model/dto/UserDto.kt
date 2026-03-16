package com.heyperdesign.restaurants.services.user.data.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("id")
    val id: String?=null,
    @SerialName("name")
    val name: String?=null,
    @SerialName("email")
    val email: String?=null,
    @SerialName("image")
    val image: String?=null,
    @SerialName("mobile")
    val phone: String?=null,
    @SerialName("balance")
    val balance: String?=null,
    @SerialName("authenticated")
    val authenticated: String?=null,
)
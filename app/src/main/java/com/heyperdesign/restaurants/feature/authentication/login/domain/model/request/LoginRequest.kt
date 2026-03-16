package com.heyperdesign.restaurants.feature.authentication.login.domain.model.request

import com.heyperdesign.restaurants.common.data.models.Const
import com.heyperdesign.restaurants.common.data.repository.remote.ErrorKeyEnum
import com.heyperdesign.restaurants.common.domain.exceptions.IErrorKeyEnum
import com.heyperdesign.restaurants.common.domain.exceptions.RequestErrorKeyValues
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("mobile")
    val phone: String,
    @SerialName("password")
    val password: String,
    @SerialName("device_token")
    val deviceToken: String= "",
    @SerialName("device_type")
    val deviceType: String,
) {
    private fun validatePhoneNumber(): Boolean = Const.phoneRegex.matches(phone)
    private fun validatePassword(): Boolean = password.isNotBlank()
    fun validateFields(): Map<IErrorKeyEnum, RequestErrorKeyValues> {
        val errors = mutableMapOf<IErrorKeyEnum, RequestErrorKeyValues>()
        if (!validatePhoneNumber()) errors[ErrorKeyEnum.PHONE_NUMBER] =
            RequestErrorKeyValues.PHONE_VALIDATION
        if (!validatePassword()) errors[ErrorKeyEnum.PASSWORD] =
            RequestErrorKeyValues.PASSWORD_VALIDATION
        return errors
    }
}
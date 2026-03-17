package com.heyperdesign.restaurants.feature.authentication.signup.domain.model.request

import com.heyperdesign.restaurants.common.data.models.Const
import com.heyperdesign.restaurants.common.data.repository.remote.ErrorKeyEnum
import com.heyperdesign.restaurants.common.domain.exceptions.IErrorKeyEnum
import com.heyperdesign.restaurants.common.domain.exceptions.RequestErrorKeyValues
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignupRequest(
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("mobile")
    val phone: String,
    @SerialName("password")
    val password: String,
) {
    private fun validateName(): Boolean = name.isNotBlank()
    private fun validateEmail(): Boolean = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun validatePhoneNumber(): Boolean = Const.phoneRegex.matches(phone)
    private fun validatePassword(): Boolean = password.isNotBlank() && password.length >= 6

    fun validateFields(): Map<IErrorKeyEnum, RequestErrorKeyValues> {
        val errors = mutableMapOf<IErrorKeyEnum, RequestErrorKeyValues>()
        if (!validateName()) errors[ErrorKeyEnum.NAME] = RequestErrorKeyValues.NAME_VALIDATION
        if (!validateEmail()) errors[ErrorKeyEnum.EMAIL] = RequestErrorKeyValues.EMAIL_VALIDATION
        if (!validatePhoneNumber()) errors[ErrorKeyEnum.PHONE_NUMBER] = RequestErrorKeyValues.PHONE_VALIDATION
        if (!validatePassword()) errors[ErrorKeyEnum.PASSWORD] = RequestErrorKeyValues.PASSWORD_VALIDATION
        return errors
    }
}

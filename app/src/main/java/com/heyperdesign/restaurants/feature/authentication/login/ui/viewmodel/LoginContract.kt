package com.heyperdesign.restaurants.feature.authentication.login.ui.viewmodel

import com.heyperdesign.restaurants.common.ui.fieldstate.TextFieldState

sealed interface LoginContract {
    sealed interface Action : LoginContract {
        data class OnPhoneChanged(val phone: String) : Action
        data class OnPasswordChanged(val password: String) : Action
        data object LoginClicked : Action
        data object OnForgetPasswordClicked : Action
        data object OnSignUpClicked : Action
    }

    data class State(
        val phone: TextFieldState = TextFieldState(),
        val password: TextFieldState = TextFieldState(),
    ) : LoginContract {
        val isLoginEnabled
            get() = phone.error == null && password.error == null
    }
}
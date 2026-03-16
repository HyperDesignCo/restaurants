package com.heyperdesign.restaurants.feature.authentication.login.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.heyperdesign.restaurants.common.data.repository.remote.ErrorKeyEnum
import com.heyperdesign.restaurants.common.domain.exceptions.IErrorKeyEnum
import com.heyperdesign.restaurants.common.ui.extensions.UIText
import com.heyperdesign.restaurants.common.ui.loading.ILoadingEvent
import com.heyperdesign.restaurants.common.ui.message.IMessageEvent
import com.heyperdesign.restaurants.common.ui.message.MessageType
import com.heyperdesign.restaurants.common.ui.viewmodel.BaseViewModel
import com.heyperdesign.restaurants.feature.authentication.login.domain.model.request.LoginRequest
import com.heyperdesign.restaurants.feature.authentication.login.domain.usecase.LoginUC
import com.hyperdesin.restaurants.R
import kotlinx.coroutines.launch

class LoginScreenVM(private val login: LoginUC) :
    BaseViewModel<LoginContract.State, LoginContract.Action>(LoginContract.State()) {
    override fun onActionTrigger(action: LoginContract.Action) {
        when (action) {
            is LoginContract.Action.OnPhoneChanged -> onPhoneChanged(phone = action.phone)
            is LoginContract.Action.OnPasswordChanged -> onPasswordChanged(action.password)
            is LoginContract.Action.LoginClicked -> onLoginClicked()
            is LoginContract.Action.OnForgetPasswordClicked -> onForgetPasswordClicked()
            is LoginContract.Action.OnSignUpClicked -> onSignUpClicked()
        }
    }

    private fun onPhoneChanged(phone: String) = updateState {
        copy(phone = this.phone.copy(value = phone, error = null))
    }

    private fun onPasswordChanged(password: String) = updateState {
        copy(password = this.password.copy(value = password, error = null))
    }

    private fun onLoginClicked() {
        val request = LoginRequest(
            phone = state.value.phone.value, password = state.value.password.value,
            deviceType = "android",
        )
        viewModelScope.launch {
            login.invoke(body = request).collectResource(
                onSuccess = {
                    fireMessage(
                        messageType = IMessageEvent.Snackbar(
                            message = UIText.StringResource(R.string.welcome_back),
                            messageType = MessageType.SUCCESS
                        )
                    )
                },
                onLoading = { fireLoading(ILoadingEvent.CircularProgressIndicator(isLoading = it)) })
        }
    }

    private fun onForgetPasswordClicked() {
        // TODO Navigate to forget password
    }

    private fun onSignUpClicked() {
        // TODO Navigate to sign up

    }

    override fun onRequestValidation(errors: Map<IErrorKeyEnum, UIText>) = updateState {
        copy(
            phone = phone.copy(error = errors[ErrorKeyEnum.PHONE_NUMBER]),
            password = password.copy(error = errors[ErrorKeyEnum.PASSWORD]),
        )
    }
}
package com.heyperdesign.restaurants.feature.entry.onboarding.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.heyperdesign.restaurants.common.ui.viewmodel.BaseViewModel
import com.heyperdesign.restaurants.feature.entry.onboarding.domain.usecase.SaveOnBoardingUC
import kotlinx.coroutines.launch

class OnBoardingViewModel(private val onBoarding: SaveOnBoardingUC) :
    BaseViewModel<OnBoardingContract.State, OnBoardingContract.Action>(OnBoardingContract.State()) {
    override fun onActionTrigger(action: OnBoardingContract.Action) {
        when (action) {
            is OnBoardingContract.Action.OnLoginClicked -> onLoginClicked()
            is OnBoardingContract.Action.OnNextClicked -> onNextClicked()
            is OnBoardingContract.Action.OnSignupClicked -> onSignupClicked()
        }
    }

    private fun onLoginClicked() {
        viewModelScope.launch {
            onBoarding.invoke(Unit).collectResource(onSuccess = { // Navigate to login
            //
            })
        }
    }

    private fun onNextClicked() {
        when (state.value.currentPage) {
            OnBoardingContract.Page.FIRST_PAGE ->
                updateState {
                    copy(currentPage = OnBoardingContract.Page.SECOND_PAGE)
                }

            OnBoardingContract.Page.SECOND_PAGE -> updateState {
                copy(currentPage = OnBoardingContract.Page.THIRD_PAGE)
            }

            OnBoardingContract.Page.THIRD_PAGE -> updateState {
                copy(currentPage = OnBoardingContract.Page.FOURTH_PAGE)
            }

            OnBoardingContract.Page.FOURTH_PAGE -> updateState {
                copy(currentPage = OnBoardingContract.Page.FIFTH_PAGE)
            }

            else -> updateState {
                copy(currentPage = OnBoardingContract.Page.SIXTH_PAGE)
            }
        }
    }
    private fun onSignupClicked() {
        viewModelScope.launch {
            onBoarding.invoke(Unit).collectResource(onSuccess = { // Navigate to signup
                //
            })
        }
    }
}



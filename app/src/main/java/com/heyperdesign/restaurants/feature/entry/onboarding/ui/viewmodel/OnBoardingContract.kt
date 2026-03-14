package com.heyperdesign.restaurants.feature.entry.onboarding.ui.viewmodel

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hyperdesin.restaurants.R

sealed interface OnBoardingContract {
    sealed interface Action : OnBoardingContract {
        data object OnNextClicked : Action
        data object OnLoginClicked : Action
        data object OnSignupClicked : Action
    }

    data class State(
        val pages: List<Page> =  Page.entries.toList(),
        val currentPage: Page = Page.FIRST_PAGE,
    ) : OnBoardingContract {
        val isLastPage
            get() = currentPage == pages.last()
    }

    enum class Page(
        @param:StringRes val title: Int = -1,
        @param:StringRes val description: Int = -1,
        @param:StringRes val buttonLabel: Int = -1,
        @param:DrawableRes val image: Int = -1,
    ) {
        FIRST_PAGE(
            title = R.string.on_boarding_title_first,
            description = R.string.on_boarding_body_first,
            buttonLabel = R.string.tell_me_more,
            image = R.drawable.img_onboarding_second
        ),
        SECOND_PAGE(
            title = R.string.on_boarding_title_second,
            description = R.string.on_boarding_body_second,
            buttonLabel = R.string.continue_button,
            image = R.drawable.img_onboarding_third
        ),
        THIRD_PAGE(
            title = R.string.on_boarding_title_third,
            description = R.string.on_boarding_body_third,
            buttonLabel = R.string.continue_button,
            image = R.drawable.img_onboarding_fourth
        ),
        FOURTH_PAGE(
            title = R.string.on_boarding_title_fourth,
            description = R.string.on_boarding_body_fourth,
            buttonLabel = R.string.continue_button,
            image = R.drawable.img_onboarding_fourth
        ),
        FIFTH_PAGE(
            title = R.string.on_boarding_title_fifth,
            description = R.string.on_boarding_body_fifth,
            buttonLabel = R.string.continue_button,
            image = R.drawable.img_onboarding_fifth
        ),
        SIXTH_PAGE(
        title = R.string.on_boarding_title_sixth,
        description = R.string.on_boarding_body_sixth,
        image = R.drawable.img_onboarding_sixth
        )
    }
}
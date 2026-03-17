package com.heyperdesign.restaurants.feature.authentication.signup.di

import com.heyperdesign.restaurants.feature.authentication.signup.domain.usecase.SignupUC
import com.heyperdesign.restaurants.feature.authentication.signup.ui.viewmodel.SignupScreenVM
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val signupModule = module {
    factoryOf(::SignupUC)
    viewModelOf(::SignupScreenVM)
}
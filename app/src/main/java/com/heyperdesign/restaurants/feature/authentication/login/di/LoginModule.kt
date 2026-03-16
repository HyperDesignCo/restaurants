package com.heyperdesign.restaurants.feature.authentication.login.di

import com.heyperdesign.restaurants.feature.authentication.login.domain.usecase.LoginUC
import com.heyperdesign.restaurants.feature.authentication.login.ui.viewmodel.LoginScreenVM
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val loginModule = module {
    factoryOf(::LoginUC)
    viewModelOf(::LoginScreenVM)
}
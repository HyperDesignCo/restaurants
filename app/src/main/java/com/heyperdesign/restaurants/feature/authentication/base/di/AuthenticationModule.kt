package com.heyperdesign.restaurants.feature.authentication.base.di

import com.heyperdesign.restaurants.feature.authentication.base.data.repository.AuthenticationRepository
import com.heyperdesign.restaurants.feature.authentication.base.data.repository.remote.AuthenticationRemoteDataSource
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.IAuthenticationRepository
import com.heyperdesign.restaurants.feature.authentication.base.domain.repository.remote.IAuthenticationRemoteDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authenticationModule = module{
    singleOf(::AuthenticationRemoteDataSource) bind IAuthenticationRemoteDataSource::class
    singleOf(::AuthenticationRepository) bind IAuthenticationRepository::class
}
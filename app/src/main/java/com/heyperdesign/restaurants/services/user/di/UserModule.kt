package com.heyperdesign.restaurants.services.user.di

import com.heyperdesign.restaurants.services.user.data.repository.UserRepository
import com.heyperdesign.restaurants.services.user.data.repository.local.UserLocalDataSource
import com.heyperdesign.restaurants.services.user.domain.repository.local.IUserLocalDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val userModule = module {
    singleOf(::UserLocalDataSource) bind IUserLocalDataSource::class
    singleOf(::UserRepository) bind UserRepository::class
}
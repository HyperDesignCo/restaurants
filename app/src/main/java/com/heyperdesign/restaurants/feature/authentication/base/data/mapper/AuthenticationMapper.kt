package com.heyperdesign.restaurants.feature.authentication.base.data.mapper

import com.heyperdesign.restaurants.common.data.mapper.Mapper
import com.heyperdesign.restaurants.feature.authentication.base.data.model.dto.AuthenticationDto
import com.heyperdesign.restaurants.feature.authentication.base.domain.model.Authentication

object AuthenticationMapper : Mapper<AuthenticationDto, Authentication, Unit>() {
    override fun dtoToDomain(model: AuthenticationDto): Authentication =
        Authentication(message = model.message.orEmpty())
}
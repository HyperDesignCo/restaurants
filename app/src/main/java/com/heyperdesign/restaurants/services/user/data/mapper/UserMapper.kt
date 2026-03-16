package com.heyperdesign.restaurants.services.user.data.mapper

import com.heyperdesign.restaurants.common.data.mapper.Mapper
import com.heyperdesign.restaurants.services.user.data.model.dto.UserDto
import com.heyperdesign.restaurants.services.user.data.model.entity.UserEntity
import com.heyperdesign.restaurants.services.user.domain.model.User

object UserMapper : Mapper<UserDto, User, UserEntity>() {
    override fun dtoToDomain(model: UserDto): User = User(
        id = model.id.orEmpty(),
        name = model.name.orEmpty(),
        email = model.email.orEmpty(),
        image = model.image.orEmpty(),
        phone = model.phone.orEmpty(),
        balance = model.balance.orEmpty(),
    )

    override fun dtoToEntity(model: UserDto): UserEntity = UserEntity(
        id = model.id.orEmpty(),
        name = model.name.orEmpty(),
        phone = model.phone.orEmpty(),
        email = model.email.orEmpty(),
        image = model.image.orEmpty(),
        balance = model.balance.orEmpty(),
        authenticated = model.authenticated.orEmpty(),
    )

    override fun entityToDomain(model: UserEntity): User = User(
        id = model.id,
        name = model.name,
        email = model.email,
        image = model.image,
        phone = model.phone,
        balance = model.balance,
    )

    override fun domainToEntity(model: User): UserEntity = UserEntity(
        id = model.id,
        name = model.name,
        phone = model.phone,
        email = model.email,
        image = model.image,
        balance = model.balance,
    )
}
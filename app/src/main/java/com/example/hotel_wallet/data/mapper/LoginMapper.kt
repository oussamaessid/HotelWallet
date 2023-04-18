package com.example.hotelwallet.data.mapper

import com.example.hotelwallet.data.model.UserDto
import com.example.hotelwallet.domain.model.User
import javax.inject.Inject

class LoginMapper @Inject constructor() :
    BaseMapper<UserDto, User> {
    override fun map(from: UserDto): User {
        return User(
            name = from.name,
            email = from.email,
            password = from.password
        )
    }

    override fun mapInverse(from: User): UserDto {
        return UserDto(
            name = from.name,
            email = from.email,
            password = from.password
        )
    }
}
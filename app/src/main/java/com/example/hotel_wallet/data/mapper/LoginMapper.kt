package com.example.hotel_wallet.data.mapper

import com.example.hotel_wallet.domain.model.User
import com.example.hotelwallet.data.model.UserDto
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
package com.example.hotel_wallet.data.mapper

import com.example.hotel_wallet.data.model.GymDto
import com.example.hotel_wallet.domain.model.Gym
import javax.inject.Inject

class GymMapper @Inject constructor() :
    BaseMapper<GymDto, Gym> {
    override fun map(from: GymDto): Gym {
        return Gym(
            id = from.id,
            nom = from.nom,
            description = from.description,
            prix = from.prix,
            image = from.image
        )
    }

    override fun mapInverse(from: Gym): GymDto {
        return GymDto(
            id = from.id,
            nom = from.nom,
            description = from.description,
            prix = from.prix,
            image = from.image
        )
    }

}
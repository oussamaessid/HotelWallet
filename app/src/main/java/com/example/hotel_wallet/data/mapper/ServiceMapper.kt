package com.example.hotel_wallet.data.mapper

import com.example.hotel_wallet.data.model.ServiceDto
import com.example.hotel_wallet.domain.model.Services
import javax.inject.Inject

class ServiceMapper @Inject constructor() :
    BaseMapper<ServiceDto, Services> {
    override fun map(from: ServiceDto): Services {
        return Services(
            id_service = from.id_service,
            nom = from.nom,
            description = from.description,
            image = from.image,
            type = from.type
        )
    }

    override fun mapInverse(from: Services): ServiceDto {
        return ServiceDto(
            id_service = from.id_service,
            nom = from.nom,
            description = from.description,
            image = from.image,
            type = from.type
        )
    }
}
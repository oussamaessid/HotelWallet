package com.example.hotel_wallet.data.mapper

import com.example.hotel_wallet.domain.model.Category
import com.example.hotel_wallet.data.model.CategoryDto
import javax.inject.Inject

class CategoryMapper @Inject constructor() :
    BaseMapper<CategoryDto, Category> {
    override fun map(from: CategoryDto): Category {
        return Category(
            id = from.id,
            nom = from.nom,
            description = from.description
        )
    }

    override fun mapInverse(from: Category): CategoryDto {
        return CategoryDto(
            id = from.id,
            nom = from.nom,
            description = from.description
        )
    }
}
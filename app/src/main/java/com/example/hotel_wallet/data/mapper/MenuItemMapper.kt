package com.example.hotel_wallet.data.mapper

import com.example.hotel_wallet.data.model.MenuItemDto
import com.example.hotel_wallet.domain.model.MenuItem
import javax.inject.Inject

class MenuItemMapper @Inject constructor() :
    BaseMapper<MenuItemDto, MenuItem> {
    override fun map(from: MenuItemDto): MenuItem {
        return MenuItem(
            id = from.id,
            nom = from.nom,
            description = from.description,
            prix = from.prix,
            image = from.image,
            categorie = from.categorie,
            id_menu = from.id_menu
        )
    }

    override fun mapInverse(from: MenuItem): MenuItemDto {
        return MenuItemDto(
            id = from.id,
            nom = from.nom,
            description = from.description,
            prix = from.prix,
            image = from.image,
            categorie = from.categorie,
            id_menu = from.id_menu
        )
    }
}
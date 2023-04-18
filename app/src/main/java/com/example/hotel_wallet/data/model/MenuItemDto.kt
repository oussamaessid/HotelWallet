package com.example.hotelwallet.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class MenuItemDto(
    @PrimaryKey
    val id: Int,
    val nom: String,
    val description: String,
    val prix: String,
    val image: String,
    val categorie: String,
    val id_menu: String
)
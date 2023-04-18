package com.example.hotel_wallet.domain.model

data class MenuItem(
    val id: Int,
    val nom: String,
    val description: String,
    val prix: String,
    val image: String,
    val categorie: String,
    val id_menu: String
)
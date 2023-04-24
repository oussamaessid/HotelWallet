package com.example.hotel_wallet.data.model

data class UserListResponse(
    val access_token: String,
    val email:String,
    val password:String,
    val status: Int
)
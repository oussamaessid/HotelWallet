package com.example.hotel_wallet.domain.repository

import com.example.hotel_wallet.utility.Resource
import com.example.hotel_wallet.data.model.MessageDto
import com.example.hotel_wallet.data.model.UserListResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun getLogin(email: String, password: String): Flow<Resource<UserListResponse>>

    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Flow<Resource<MessageDto>>

}
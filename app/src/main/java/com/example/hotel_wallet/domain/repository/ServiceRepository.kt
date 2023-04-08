package com.example.hotel_wallet.domain.repository

import com.example.hotel_wallet.domain.model.Services
import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {
    suspend fun getServices(): Flow<Resource<List<Services>>>
}
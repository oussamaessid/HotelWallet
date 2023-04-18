package com.example.hotel_wallet.domain.model

import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow

interface GymRepository {
    suspend fun getGym(category: String): Flow<Resource<List<Gym>>>

}
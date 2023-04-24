package com.example.hotel_wallet.domain.repository

import com.example.hotel_wallet.domain.model.MenuItem
import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    suspend fun getMenu(category: String): Flow<Resource<List<MenuItem>>>

}
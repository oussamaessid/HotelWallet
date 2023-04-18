package com.example.hotel_wallet.domain.model

import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(category: String): Flow<Resource<List<Category>>>
}
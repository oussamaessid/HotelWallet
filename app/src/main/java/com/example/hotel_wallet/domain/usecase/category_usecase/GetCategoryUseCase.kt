package com.example.hotel_wallet.domain.usecase.category_usecase


import com.example.hotel_wallet.domain.model.Category
import com.example.hotel_wallet.domain.model.CategoryRepository
import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(category: String): Flow<Resource<List<Category>>> =
        repository.getCategories(category)
}
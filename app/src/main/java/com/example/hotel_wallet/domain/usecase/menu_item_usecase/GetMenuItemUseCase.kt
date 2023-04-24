package com.example.hotel_wallet.domain.usecase.menu_item_usecase

import com.example.hotel_wallet.domain.model.MenuItem
import com.example.hotel_wallet.domain.repository.MenuRepository
import com.example.hotel_wallet.utility.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMenuItemUseCase @Inject constructor(
    private val repository: MenuRepository
) {
    suspend operator fun invoke(category: String): Flow<Resource<List<MenuItem>>> =
        repository.getMenu(category)
}
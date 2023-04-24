package com.example.hotel_wallet.data.repository

import android.util.Log
import com.example.hotel_wallet.data.mapper.MenuItemMapper
import com.example.hotel_wallet.domain.model.MenuItem
import com.example.hotel_wallet.domain.repository.MenuRepository
import com.example.hotel_wallet.utility.Resource
import com.example.hotel_wallet.data.source.remote.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MenuItemRepositoryImpl @Inject constructor(
    private val api: Api,
    private val menuItemMapper: MenuItemMapper,
) : MenuRepository {
    override suspend fun getMenu(category: String): Flow<Resource<List<MenuItem>>> = flow {
        try {
            emit(Resource.Loading)
            val categoriesResponse = menuItemMapper.mapList(
                api.getMenuItems(category).plat
            )
            Log.println(Log.ASSERT, "categoriesResponse", categoriesResponse.toString())
            emit(Resource.Success(categoriesResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

}

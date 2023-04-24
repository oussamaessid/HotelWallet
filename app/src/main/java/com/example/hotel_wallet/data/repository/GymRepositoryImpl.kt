package com.example.hotel_wallet.data.repository

import android.util.Log
import com.example.hotel_wallet.data.mapper.GymMapper
import com.example.hotel_wallet.domain.model.Gym
import com.example.hotel_wallet.domain.model.GymRepository
import com.example.hotel_wallet.utility.Resource
import com.example.hotel_wallet.data.source.remote.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GymRepositoryImpl @Inject constructor(
    private val api: Api,
    private val gymMapper: GymMapper,
) : GymRepository {
    override suspend fun getGym(category: String): Flow<Resource<List<Gym>>> = flow {
        try {
            emit(Resource.Loading)
            val categoriesResponse = gymMapper.mapList(
                api.getGym(category).plans
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

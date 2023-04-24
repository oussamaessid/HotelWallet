package com.example.hotel_wallet.data.repository

import com.example.hotel_wallet.data.mapper.ServiceMapper
import com.example.hotel_wallet.domain.model.Services
import com.example.hotel_wallet.domain.repository.ServiceRepository
import com.example.hotel_wallet.utility.Resource
import com.example.hotel_wallet.data.source.remote.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ServicesRepositoryImpl @Inject constructor(
    private val api: Api,
    private val serviceMapper: ServiceMapper,
) : ServiceRepository {
    override suspend fun getServices(): Flow<Resource<List<Services>>> = flow {
        try {
            emit(Resource.Loading)
            val categoriesResponse = serviceMapper.mapList(
                api.getServices().message
            )
            emit(Resource.Success(categoriesResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

}

package com.example.hotel_wallet.data.source.remote

import com.example.hotel_wallet.data.model.ServiceListResponse
import retrofit2.http.GET

interface Api {

    @GET("services")
    suspend fun getServices(): ServiceListResponse
}
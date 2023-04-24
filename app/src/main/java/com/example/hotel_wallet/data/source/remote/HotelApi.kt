package com.example.hotel_wallet.data.source.remote

import com.example.hotel_wallet.data.model.MenuItemListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HotelApi {

    @GET("filter.php")
    suspend fun getMenuItems(
        @Query("c") category: String
    ): MenuItemListResponse

}
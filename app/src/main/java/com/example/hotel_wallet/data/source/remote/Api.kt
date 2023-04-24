package com.example.hotel_wallet.data.source.remote

import com.example.hotel_wallet.data.model.*
import com.example.hotel_wallet.domain.model.Login
import com.example.hotel_wallet.domain.model.SignUp
import com.example.hotelwallet.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("services")
    suspend fun getServices(): ServiceListResponse

    @GET("menu/{id}")
    suspend fun getCategories(
        @Path("id") categoryId: String
    ): CategoryListResponse

    @GET("plats/{id}")
    suspend fun getMenuItems(
        @Path("id") id: String
    ): MenuItemListResponse

    @GET("plans/{id}")
    suspend fun getGym(
        @Path("id") id: String
    ): GymListResponse


    @POST("auth/loginUser")
    suspend fun login(@Body credentials: Login): Response<UserListResponse>

    @POST("auth/createUser")
    suspend fun signUp(@Body credentials: SignUp): Response<MessageDto>

}
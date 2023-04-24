package com.example.hotel_wallet.di

import com.example.hotel_wallet.data.mapper.*
import com.example.hotel_wallet.data.repository.*
import com.example.hotel_wallet.data.source.remote.Api
import com.example.hotel_wallet.data.source.remote.HotelApi
import com.example.hotel_wallet.domain.model.CategoryRepository
import com.example.hotel_wallet.domain.model.GymRepository
import com.example.hotel_wallet.domain.repository.LoginRepository
import com.example.hotel_wallet.domain.repository.MenuRepository
import com.example.hotel_wallet.domain.repository.ServiceRepository
import com.example.hotel_wallet.utility.BASE_URL
import com.example.hotel_wallet.utility.BASE_URL1
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideHoteloApi(): HotelApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(HotelApi::class.java)
    }

    @Singleton
    @Provides
    fun provideApi(): Api {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL1)
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideCategoryRepository(
        api: Api,
        categoryMapper: CategoryMapper
    ): CategoryRepository =
        CategoryRepositoryImpl(api = api, categoryMapper = categoryMapper)

    @Singleton
    @Provides
    fun provideMenuItemRepository(
        api: Api,
        menuItemMapper: MenuItemMapper
    ): MenuRepository =
        MenuItemRepositoryImpl(api = api, menuItemMapper = menuItemMapper)

    @Singleton
    @Provides
    fun provideServiceRepository(
        api: Api,
        serviceMapper: ServiceMapper,
    ): ServiceRepository =
        ServicesRepositoryImpl(api = api, serviceMapper = serviceMapper)

    @Singleton
    @Provides
    fun provideGymRepository(
        api: Api,
        gymMapper: GymMapper
    ): GymRepository =
        GymRepositoryImpl(api = api, gymMapper = gymMapper)

    @Singleton
    @Provides
    fun provideLoginRepository(
        api: Api,
        loginMapper: LoginMapper,
        messageMapper: MessageMapper
    ): LoginRepository =
        LoginRepositoryImpl(api = api, loginMapper = loginMapper, messageMapper = messageMapper)
}
package com.example.hotel_wallet.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Basket::class], version = 1)
abstract class AppBasket : RoomDatabase() {
    abstract fun favoriteDao(): BasketsDao
}
package com.example.hotel_wallet.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hotel_wallet.data.source.local.Basket

@Dao
interface BasketsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(basket: Basket)

    @Delete
    suspend fun deleteFavorite(basket: Basket)

    @Query("SELECT * FROM favorite_table")
    fun getAllFavorites(): LiveData<List<Basket>>
}

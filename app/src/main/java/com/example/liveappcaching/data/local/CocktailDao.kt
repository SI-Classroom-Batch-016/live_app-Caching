package com.example.liveappcaching.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liveappcaching.data.model.Drink
import com.example.liveappcaching.data.model.DrinkDetails

@Dao
interface CocktailDao {

    @Query("SELECT * FROM Drink")
    fun getAll() : LiveData<List<Drink>>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: Drink)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkDetail(drinkDetails: DrinkDetails)

    @Query("SELECT * FROM DrinkDetails WHERE id=:id")
    fun getDrinkDetails(id : Int) : LiveData<DrinkDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(drink: List<Drink>)


}
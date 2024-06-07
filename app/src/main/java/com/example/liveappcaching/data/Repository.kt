package com.example.liveappcaching.data

import android.util.Log
import com.example.liveappcaching.data.local.CocktailDatabase
import com.example.liveappcaching.data.remote.CocktailApi

const val TAG = "Repository"

class Repository(val database: CocktailDatabase) {

    val drinks = database.dao.getAll()

    fun drinkDetails(id: Int) = database.dao.getDrinkDetails(id)

    suspend fun cacheDrinkDetails(id: Int) {
        try {
            //Lade Drink Details
            val cocktailDetails = CocktailApi.apiService.getCocktailDetails(id).drinks.first()
            //speicher in Room Datenbank
            database.dao.insertDrinkDetail(cocktailDetails)

        } catch (ex: Exception) {

            Log.e(TAG, ex.toString())
        }
    }

    suspend fun loadData() {
        try {
            val response = CocktailApi.apiService.getCocktails()
            Log.d(TAG, response.toString())

            //Daten umformatieren sodass sie in eine Datenbank
            val drinkList = response.drinks

            database.dao.insertList(drinkList)
        } catch (ex: Exception) {

            Log.e(TAG, ex.toString())
        }
    }

}
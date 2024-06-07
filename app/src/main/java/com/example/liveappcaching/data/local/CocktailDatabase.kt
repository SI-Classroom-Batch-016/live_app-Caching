package com.example.liveappcaching.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.liveappcaching.data.model.Drink
import com.example.liveappcaching.data.model.DrinkDetails

@Database(entities = [Drink::class, DrinkDetails::class], version = 1)
abstract class CocktailDatabase : RoomDatabase() {
    abstract val dao: CocktailDao
}

private lateinit var INSTANCE : CocktailDatabase

fun getInstance(context : Context) : CocktailDatabase{

    synchronized(CocktailDatabase::class.java) {
        if(!::INSTANCE.isInitialized) {
            //Datenbank initialisieren und in INSTANCE Variable speichern
            INSTANCE = Room.databaseBuilder(
                context = context,
                klass = CocktailDatabase::class.java,
                name = "cocktail_database"
            ).build()
        }
        return INSTANCE
    }
}
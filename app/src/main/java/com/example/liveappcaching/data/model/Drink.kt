package com.example.liveappcaching.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Drink(

    @PrimaryKey
    @Json(name = "idDrink")
    val id: Int,

    @Json(name = "strDrink")
    val name: String,
    @Json(name = "strDrinkThumb")
    val thumbnail: String,
)
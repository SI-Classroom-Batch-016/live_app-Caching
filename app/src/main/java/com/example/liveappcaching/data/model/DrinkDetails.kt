package com.example.liveappcaching.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class DrinkDetails(

    @PrimaryKey
    @Json(name = "idDrink")
    val id: Int,

    @Json(name = "strDrink")
    val name: String,
    @Json(name = "strDrinkThumb")
    val thumbnail: String,

    @Json(name = "strInstructions")
    val instructions : String,
    @Json(name = "strInstructionsDE")
    val instructionsDE : String?,
    @Json(name = "strCategory")
    val category: String,
)
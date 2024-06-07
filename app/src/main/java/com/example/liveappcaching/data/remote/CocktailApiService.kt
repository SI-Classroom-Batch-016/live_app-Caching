package com.example.liveappcaching.data.remote

import com.example.liveappcaching.data.model.DrinkDetailsResponse
import com.example.liveappcaching.data.model.DrinkListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CocktailApiService {

    @GET("filter.php?c=Cocktail")
    suspend fun getCocktails() : DrinkListResponse

    //https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007
    @GET("lookup.php")
    suspend fun getCocktailDetails(@Query("i")id: Int) : DrinkDetailsResponse

}

object CocktailApi {
    val apiService: CocktailApiService by lazy { retrofit.create(CocktailApiService::class.java) }
}

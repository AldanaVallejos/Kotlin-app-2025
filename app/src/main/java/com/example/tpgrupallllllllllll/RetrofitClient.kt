package com.example.tpgrupallllllllllll

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    // NECESITAMOS CAMBIAR LA URL
    private val baseURL = "https://store.steampowered.com/api/appdetails?appids=570"

    private val moshi = Moshi.Builder()
        .addLast { KotlinJsonAdapterFactory() }
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

}
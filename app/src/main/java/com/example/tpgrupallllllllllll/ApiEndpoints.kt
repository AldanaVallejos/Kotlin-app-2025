package com.example.tpgrupallllllllllll

import com.example.tpgrupallllllllllll.dtos.GameDTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoints {
    @GET("api/games")
    fun getDetails() : Call<List<GameDTO>>
}
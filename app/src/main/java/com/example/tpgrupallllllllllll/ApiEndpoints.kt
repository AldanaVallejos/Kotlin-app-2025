package com.example.tpgrupallllllllllll

import com.example.tpgrupallllllllllll.dtos.PostDTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoints {
    //NECESITAMOS CAMBIAR EL ENDPOINT
    @GET("/appdetails?appids=570")
    fun getDetails() : Call<List<PostDTO>>
}
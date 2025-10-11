package com.example.tpgrupallllllllllll.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostDTO (
    var id : Int?,
    var description : String
)
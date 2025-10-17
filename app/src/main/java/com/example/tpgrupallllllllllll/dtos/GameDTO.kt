package com.example.tpgrupallllllllllll.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameDTO (
    var title : String?,
    var short_description : String?,
    var release_date : String?,
    var developer : String?,
    var genre : String?,
    var platform : String?
)
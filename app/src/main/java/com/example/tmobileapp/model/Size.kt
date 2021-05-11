package com.example.tmobileapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Size(
    @Json(name = "height")
    val height: Int?,
    @Json(name = "width")
    val width: Int?
)
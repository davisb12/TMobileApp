package com.example.tmobileapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Font(
    @Json(name = "size")
    val size: Int?
)
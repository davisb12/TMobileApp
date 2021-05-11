package com.example.tmobileapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "size")
    val size: Size?,
    @Json(name = "url")
    val url: String?
)
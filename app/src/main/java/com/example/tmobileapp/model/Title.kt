package com.example.tmobileapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Title(
    @Json(name = "attributes")
    val attributes: Attributes?,
    @Json(name = "value")
    val value: String?
)
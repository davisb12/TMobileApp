package com.example.tmobileapp.model

import com.example.tmobileapp.model.Page
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageResponse(
    @Json(name = "page")
    val page: Page?
)

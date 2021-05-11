package com.example.tmobileapp.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Page(
    @PrimaryKey
    val id: Int = 0,
    @Json(name = "cards")
    val cards: List<CardHolder>?
)
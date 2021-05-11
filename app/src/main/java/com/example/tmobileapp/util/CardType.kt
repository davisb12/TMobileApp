package com.example.tmobileapp.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.util.*

enum class CardType {
    TEXT, TITLE_DESCRIPTION, IMAGE_TITLE_DESCRIPTION
}

val CardType.typeString
    get() = name.toLowerCase(Locale.getDefault())

object CardTypeAdapter {

    @FromJson
    fun fromString(type: String) = when (type) {
        CardType.TEXT.typeString -> CardType.TEXT
        CardType.TITLE_DESCRIPTION.typeString -> CardType.TITLE_DESCRIPTION
        CardType.IMAGE_TITLE_DESCRIPTION.typeString -> CardType.IMAGE_TITLE_DESCRIPTION
        else -> null
    }

    @ToJson
    fun toString(type: CardType) = type.typeString
}
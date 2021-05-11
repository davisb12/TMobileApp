package com.example.tmobileapp.repo.local

import androidx.room.TypeConverter
import com.example.tmobileapp.model.CardHolder
import com.example.tmobileapp.model.Page
import com.example.tmobileapp.repo.remote.RetrofitInstance
import com.example.tmobileapp.util.CardTypeAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {

    private val moshi by lazy { RetrofitInstance.moshi }
    private val pageAdapter = moshi.adapter(Page::class.java)
    private val cardHolderType =
        Types.newParameterizedType(List::class.java, CardHolder::class.java)
    private val cardHolderAdapter = moshi.adapter<List<CardHolder>>(cardHolderType)

    @TypeConverter
    fun stringToPager(value: String): Page? = moshi.adapter(Page::class.java).fromJson(value)

    @TypeConverter
    fun pageToString(page: Page): String = pageAdapter.toJson(page)

    @TypeConverter
    fun stringToCardHolderList(value: String): List<CardHolder>? = cardHolderAdapter.fromJson(value)

    @TypeConverter
    fun cardHolderListToString(page: List<CardHolder>): String = cardHolderAdapter.toJson(page)

}
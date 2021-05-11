package com.example.tmobileapp.repo.remote

import com.example.tmobileapp.util.CardTypeAdapter
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com"

    val moshi = Moshi.Builder().add(CardTypeAdapter).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val pageService: PageService by lazy { retrofit.create(PageService::class.java) }
}
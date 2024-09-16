package com.example.testtask24.firstScreen.data

import com.example.testtask24.firstScreen.data.models.CardInfoDto
import com.example.testtask24.firstScreen.data.models.NumberCardDto
import retrofit2.http.GET
import retrofit2.http.Url

interface BinListApi {
    @GET
    suspend fun getInfo(@Url number: String): CardInfoDto
}
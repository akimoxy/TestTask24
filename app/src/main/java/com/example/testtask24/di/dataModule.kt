package com.example.testtask24.di

import com.example.testtask24.firstScreen.data.BinListApi
import com.google.gson.Gson
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val BASE_URL="https://lookup.binlist.net"

val dataModule= module {
    factory { Gson() }
    single<BinListApi> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinListApi::class.java)
    }
}
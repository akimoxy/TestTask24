package com.example.testtask24.firstScreen.data

import retrofit2.http.GET
import retrofit2.http.Url

interface BinListApi {
@GET("/")
suspend fun getInfo(@Url number:Int):
}
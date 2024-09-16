package com.example.testtask24.firstScreen.domain.api

import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.domain.models.CardInfoResponse

interface SearchRepository {
    suspend fun searchInfo(number:String): CardInfoResponse
}
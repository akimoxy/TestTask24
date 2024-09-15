package com.example.testtask24.firstScreen.domain.api

import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.domain.models.CardInfoResponse

interface SearchInteractor {
    suspend fun searchInfo(number:String):CardInfoResponse
}
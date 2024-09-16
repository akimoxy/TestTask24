package com.example.testtask24.firstScreen.domain.api

import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.domain.models.CardInfoResponse

class SearchInteractorImpl(private val repository: SearchRepository) : SearchInteractor {
    override suspend fun searchInfo(number: String): CardInfoResponse {
        return repository.searchInfo(number)
    }
}
package com.example.testtask24.secondScreen.domain

import com.example.testtask24.firstScreen.domain.models.CardInfo
import kotlinx.coroutines.flow.Flow

class HistoryInteractorImpl(private val repo: HistoryRepository) : HistoryInteractor {
    override suspend fun saveToHistory(card: CardInfo) {
        repo.saveToHistory(card)
    }

    override fun getAllHistory(): Flow<List<CardInfo>> {
        return repo.getAllHistory()
    }
}
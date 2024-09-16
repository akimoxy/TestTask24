package com.example.testtask24.secondScreen.domain

import com.example.testtask24.firstScreen.domain.models.CardInfo
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun saveToHistory(card: CardInfo)
    fun getAllHistory(): Flow<List<CardInfo>>
}
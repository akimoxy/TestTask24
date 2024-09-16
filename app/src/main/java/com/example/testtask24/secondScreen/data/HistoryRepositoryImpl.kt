package com.example.testtask24.secondScreen.data

import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.secondScreen.domain.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class HistoryRepositoryImpl(
    private val converter: CardDbConverter,
    private val appDataBase: AppDataBase
) : HistoryRepository {
    override suspend fun saveToHistory(card: CardInfo) {
        val allInfoCard = converter.cardInfoToAllCard(card)
        appDataBase.cardInfoDao().insertCardInfo(allInfoCard)
    }

    override fun getAllHistory(): Flow<List<CardInfo>> {
        val some = appDataBase.cardInfoDao().getAllCardsInfo()
        return covertFromTrackEntity(some)

    }

    private fun covertFromTrackEntity(card: Flow<List<AllCardInfo>>): Flow<List<CardInfo>> {
        return card.map { list -> list.map { converter.cardEntityToCardInfo(it) } }
    }
}
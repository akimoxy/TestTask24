package com.example.testtask24.firstScreen.data

import com.example.testtask24.firstScreen.Converter
import com.example.testtask24.firstScreen.data.models.CardInfoDto
import com.example.testtask24.firstScreen.data.models.SearchRequest
import com.example.testtask24.firstScreen.domain.api.SearchRepository
import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.domain.models.CardInfoResponse

class SearchrepositoryImpl(
    private val networkClient: NetworkClient,
    private val converter: Converter
) : SearchRepository {
    override suspend fun searchInfo(number: String): CardInfoResponse {
        val response = networkClient.doRequest(SearchRequest(number))
        if (response.resultCode == SERVER_CODE_200) {
            val cardInfo = converter.cardInfoDtoToCardInfo(response as CardInfoDto)
            return CardInfoResponse(cardInfo, SERVER_CODE_200)
        } else {
            return CardInfoResponse(
                null,
                SERVER_CODE_400
            )
        }
    }
}
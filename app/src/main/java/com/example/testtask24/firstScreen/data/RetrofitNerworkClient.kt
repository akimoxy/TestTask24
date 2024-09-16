package com.example.testtask24.firstScreen.data

import com.example.testtask24.firstScreen.data.models.Response
import com.example.testtask24.firstScreen.data.models.SearchRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val SERVER_CODE_200 = 200
const val SERVER_CODE_400 = 400

class RetrofitNetworkClient(val api: BinListApi) : NetworkClient {
    override suspend fun doRequest(dto: Any): Response {
        return if (dto is SearchRequest) {
            withContext(Dispatchers.IO) {
                try {
                    val response = api.getInfo(dto.text)
                    response.apply { resultCode = SERVER_CODE_200 }
                } catch (e: Throwable) {
                    Response().apply { resultCode = SERVER_CODE_400 }
                }
            }
        } else {
            Response().apply { resultCode = SERVER_CODE_400 }
        }
    }
}


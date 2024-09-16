package com.example.testtask24.firstScreen.data

import com.example.testtask24.firstScreen.data.models.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}
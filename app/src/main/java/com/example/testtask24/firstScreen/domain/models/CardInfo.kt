package com.example.testtask24.firstScreen.domain.models

data class CardInfo(
    val number: NumberCard?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: Country?,
    val bank: Bank
)

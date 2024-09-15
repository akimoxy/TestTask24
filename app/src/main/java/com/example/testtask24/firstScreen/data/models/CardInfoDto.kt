package com.example.testtask24.firstScreen.data.models

data class CardInfoDto(
    val number: NumberCardDto?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryDto?,
    val bank: BankDto?
) : Response()

//
package com.example.testtask24.firstScreen

import com.example.testtask24.firstScreen.data.models.BankDto
import com.example.testtask24.firstScreen.data.models.CardInfoDto
import com.example.testtask24.firstScreen.data.models.CountryDto
import com.example.testtask24.firstScreen.data.models.NumberCardDto
import com.example.testtask24.firstScreen.domain.models.Bank
import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.domain.models.Country
import com.example.testtask24.firstScreen.domain.models.NumberCard

class Converter {
    fun cardInfoDtoToCardInfo(cardInfoDto: CardInfoDto): CardInfo {
        return CardInfo(
            number = numberCardDtoToNumberCard(cardInfoDto.number),
            scheme = cardInfoDto.scheme,
            type = cardInfoDto.type,
            brand = cardInfoDto.brand,
            prepaid = cardInfoDto.prepaid,
            country = countryDtoToCountry(cardInfoDto.country),
            bank = bankDtoToBank(cardInfoDto.bank)
        )
    }

    private fun bankDtoToBank(bankDto: BankDto?): Bank {
        return Bank(
            name = bankDto?.name,
            url = bankDto?.url,
            phone = bankDto?.phone,
            city = bankDto?.city
        )
    }

    private fun countryDtoToCountry(countryDto: CountryDto?): Country {
        return Country(
            numeric = countryDto?.numeric,
            alpha2 = countryDto?.alpha2,
            name = countryDto?.name,
            emoji = countryDto?.emoji,
            currency = countryDto?.currency,
            latitude = countryDto?.latitude,
            longitude = countryDto?.longitude
        )

    }

    private fun numberCardDtoToNumberCard(numberCardDto: NumberCardDto?): NumberCard {
        return NumberCard(
            length = numberCardDto?.length,
            luhn = numberCardDto?.luhn
        )
    }
}
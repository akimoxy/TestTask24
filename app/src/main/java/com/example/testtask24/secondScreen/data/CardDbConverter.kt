package com.example.testtask24.secondScreen.data

import com.example.testtask24.firstScreen.domain.models.Bank
import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.domain.models.Country
import com.example.testtask24.firstScreen.domain.models.NumberCard

class CardDbConverter {
    fun cardEntityToCardInfo(cardInfo: AllCardInfo): CardInfo {
        return CardInfo(
            number =
            numberCardDtoToNumberCard(cardInfo.numberCardEntity),
            scheme = cardInfo.cardEntity.scheme,
            type = cardInfo.cardEntity.type,
            brand = cardInfo.cardEntity.brand,
            prepaid = cardInfo.cardEntity.prepaid,
            country = countryDtoToCountry(cardInfo.countryEntity),
            bank = bankDtoToBank(cardInfo.bankEntity)
        )
    }

    private fun bankDtoToBank(bankDto: BankEntity?): Bank {
        return Bank(
            name = bankDto?.name,
            url = bankDto?.url,
            phone = bankDto?.phone,
            city = bankDto?.city
        )
    }

    private fun countryDtoToCountry(countryDto: CountryEntity?): Country {
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

    private fun numberCardDtoToNumberCard(numberCard: NumberCardEntity?): NumberCard {
        return NumberCard(
            length = numberCard?.length,
            luhn = numberCard?.luhn
        )
    }

    fun cardInfoToCardEntity(cardInfo: CardInfo): CardEntity {
        return CardEntity(
            id = 0,
            scheme = cardInfo.scheme,
            type = cardInfo.type,
            brand = cardInfo.brand,
            prepaid = cardInfo.prepaid
        )
    }

    fun cardInfoToAllCard(cardInfo: CardInfo): AllCardInfo {
        return AllCardInfo(
            cardEntity = cardInfoToCardEntity(cardInfo),
            numberCardEntity = numberCardToNumberCardEntity(cardInfo.number),
            bankEntity = bankToBankEntity(cardInfo.bank),
            countryEntity = country0ToCountryEntity(cardInfo.country)
        )
    }

    private fun bankToBankEntity(bank: Bank?): BankEntity {
        return BankEntity(
            id = 0,

            name = bank?.name,
            url = bank?.url,
            phone = bank?.phone,
            city = bank?.city
        )
    }

    private fun country0ToCountryEntity(countryDto: Country?): CountryEntity {
        return CountryEntity(
            numeric = countryDto?.numeric,
            alpha2 = countryDto?.alpha2,
            name = countryDto?.name,
            emoji = countryDto?.emoji,
            currency = countryDto?.currency,
            latitude = countryDto?.latitude,
            longitude = countryDto?.longitude, id = 0
        )

    }

    private fun numberCardToNumberCardEntity(numberCard: NumberCard?): NumberCardEntity {
        return NumberCardEntity(
            length = numberCard?.length,
            luhn = numberCard?.luhn,
            id = 0
        )
    }


}
package com.example.testtask24.firstScreen.presentation

import com.example.testtask24.firstScreen.domain.models.CardInfo

sealed class FirstFragmentState {
    data object BeforeSearch : FirstFragmentState()
    data class FoundInfo(val cardInfo: CardInfo) : FirstFragmentState()
    data object Error : FirstFragmentState()
}
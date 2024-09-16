package com.example.testtask24.secondScreen.presentation

import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.presentation.FirstFragmentState

sealed class SecondFragmentState {
    data object EmptyHistory : SecondFragmentState()
    data class History(val cardInfo: List<CardInfo>) : SecondFragmentState()
}
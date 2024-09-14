package com.example.testtask24.firstScreen.presentation

sealed class FirstFragmentState {
    data object FoundInfo : FirstFragmentState()
    data object Error : FirstFragmentState()
}
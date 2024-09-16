package com.example.testtask24.di

import com.example.testtask24.firstScreen.presentation.FirstFragmentViewModel
import com.example.testtask24.secondScreen.presentation.SecondFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel<SecondFragmentViewModel> { SecondFragmentViewModel(historyInteractor = get()) }
    viewModel<FirstFragmentViewModel> {
        FirstFragmentViewModel(
            seachInteractor = get(),
            historyInteractor = get()
        )
    }

}
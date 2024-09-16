package com.example.testtask24.di

import com.example.testtask24.firstScreen.data.SearchrepositoryImpl
import com.example.testtask24.firstScreen.domain.api.SearchInteractor
import com.example.testtask24.firstScreen.domain.api.SearchInteractorImpl
import com.example.testtask24.firstScreen.domain.api.SearchRepository
import com.example.testtask24.secondScreen.data.HistoryRepositoryImpl
import com.example.testtask24.secondScreen.domain.HistoryInteractor
import com.example.testtask24.secondScreen.domain.HistoryInteractorImpl
import com.example.testtask24.secondScreen.domain.HistoryRepository
import org.koin.dsl.module

val domainModule = module {

    factory<SearchInteractor> { SearchInteractorImpl(repository = get()) }
    factory<SearchRepository> { SearchrepositoryImpl(networkClient = get(), converter = get()) }
    factory<HistoryRepository> { HistoryRepositoryImpl(converter = get(), appDataBase = get()) }
    factory<HistoryInteractor> { HistoryInteractorImpl(repo = get()) }
}
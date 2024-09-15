package com.example.testtask24.di

import com.example.testtask24.firstScreen.data.SearchrepositoryImpl
import com.example.testtask24.firstScreen.domain.api.SearchInteractor
import com.example.testtask24.firstScreen.domain.api.SearchInteractorImpl
import com.example.testtask24.firstScreen.domain.api.SearchRepository
import org.koin.dsl.module

val domainModule= module {

    factory <SearchInteractor> { SearchInteractorImpl(repository = get()) }
    factory <SearchRepository>{SearchrepositoryImpl(networkClient = get(), converter = get())  }
}
package com.example.testtask24

import android.app.Application
import com.example.testtask24.di.dataModule
import com.example.testtask24.di.domainModule
import com.example.testtask24.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, presentationModule)
        }
    }
}
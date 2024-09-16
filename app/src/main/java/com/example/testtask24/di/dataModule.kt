package com.example.testtask24.di

import androidx.room.Room
import com.example.testtask24.firstScreen.data.Converter
import com.example.testtask24.firstScreen.data.BinListApi
import com.example.testtask24.firstScreen.data.NetworkClient
import com.example.testtask24.firstScreen.data.RetrofitNetworkClient
import com.example.testtask24.firstScreen.data.SearchrepositoryImpl
import com.example.testtask24.firstScreen.domain.api.SearchRepository
import com.example.testtask24.secondScreen.data.AppDataBase
import com.example.testtask24.secondScreen.data.CardDbConverter
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://lookup.binlist.net/"

val dataModule = module {
    factory { Gson() }
    single<BinListApi> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
            .create(BinListApi::class.java)
    }
    factory<OkHttpClient> {
        OkHttpClient()
            .newBuilder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single<NetworkClient> {
        RetrofitNetworkClient(api = get())
    }
    single<SearchRepository> {
        SearchrepositoryImpl(networkClient = get(), converter = get())
    }
    factory { Converter() }

    single {
        Room.databaseBuilder(androidContext(), AppDataBase::class.java, "database.db").build()
    }

    factory { CardDbConverter() }

}
package com.example.testtask24.secondScreen.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [CardEntity::class, CountryEntity::class, NumberCardEntity::class, BankEntity::class]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cardInfoDao(): CardDao
}
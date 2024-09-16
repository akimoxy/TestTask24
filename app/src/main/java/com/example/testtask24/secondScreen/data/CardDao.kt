package com.example.testtask24.secondScreen.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: CardEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBank(card: BankEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(card: CountryEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumberCard(card: NumberCardEntity): Long

    suspend fun insertCardInfo(card: AllCardInfo) {
        //  val vacancyEntity =
        insertCard(card.cardEntity)
        //   val bankId =
        if (card.bankEntity!=null) insertBank(card.bankEntity)

        //    val countryId =
        if(card.countryEntity!=null) insertCountry(card.countryEntity)
        if(card.numberCardEntity!=null) insertNumberCard(card.numberCardEntity)
     //   insertNumberCard(card.numberCardEntity)
        //   val numberCardId =
        //  insertNumberCard(vacancy.numberCardEntity)
    }


    @Transaction
    @Query("SELECT * FROM cardInfo ORDER BY id DESC")
    fun getAllCardsInfo(): Flow<List<AllCardInfo>>
}
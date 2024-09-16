package com.example.testtask24.secondScreen.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation


@Entity(tableName = "cardInfo",
        indices = [Index("id")])
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long ,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?
)

@Entity(tableName = "numberCardInfo")
data class NumberCardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val length: Int?,
    val luhn: Boolean?,

)

@Entity(tableName = "bankInfo")
data class BankEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?,

)

@Entity(tableName = "countryInfo")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val numeric: Int?,
    val alpha2: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?,

)

data class AllCardInfo(
    @Embedded
    val cardEntity: CardEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val numberCardEntity: NumberCardEntity?,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val bankEntity: BankEntity?,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val countryEntity: CountryEntity?


)
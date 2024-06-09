package com.tfg.meteodirecto.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "favoritos", primaryKeys = ["CODAUTO","CPRO","CMUN","DC","NOMBRE"])
data class Favoritos (
    @ColumnInfo("CODAUTO") val CODAUTO: String,
    @ColumnInfo("CPRO") val CPRO: String,
    @ColumnInfo("CMUN") val CMUN: String,
    @ColumnInfo("DC") val DC: String,
    @ColumnInfo("NOMBRE") val NOMBRE: String,
    @ColumnInfo("IsSelected") var isSelected:Int
    )
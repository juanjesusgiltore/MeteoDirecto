package com.tfg.meteodirecto.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "localidades", primaryKeys = ["NOMBRE","DC","CMUN","CPRO","CODAUTO"])
data class Localidades (
    @ColumnInfo("CODAUTO")val CODAUTO:String,
    @ColumnInfo("CPRO")val CPRO:String,
    @ColumnInfo("CMUN")val CMUN:String,
    @ColumnInfo("DC")val DC:String,
    @ColumnInfo("NOMBRE")val NOMBRE:String,
)
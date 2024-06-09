package com.tfg.meteodirecto.database.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tfg.meteodirecto.database.entities.Favoritos

@Dao
interface InterfazDaoFavoritos {
    @Query("select*from favoritos")
    fun getAllFavoritos():List<Favoritos>

    @Insert
    fun insertarFavorito(faoritos: Favoritos)

    @Delete
    fun eliminarFavorito(faoritos: Favoritos)

    @Update
    fun actualizarFavorito(favoritos: Favoritos)
}
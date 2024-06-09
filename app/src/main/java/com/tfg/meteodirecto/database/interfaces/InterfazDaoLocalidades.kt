package com.tfg.meteodirecto.database.interfaces

import androidx.room.Dao
import androidx.room.Query
import com.tfg.meteodirecto.database.entities.Localidades

@Dao
interface InterfazDaoLocalidades {

    @Query("select*from localidades")
    fun getAllLocalidades():List<Localidades>

}


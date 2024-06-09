package com.tfg.meteodirecto.peticion.data

import com.tfg.meteodirecto.peticion.data.dataTiempo.Origen
import com.tfg.meteodirecto.peticion.data.dataTiempo.Prediccion

data class TiempoItem(
    val elaborado: String,
    val id: Int,
    val nombre: String,
    val origen: Origen,
    val prediccion: Prediccion,
    val provincia: String,
    val version: Double
)
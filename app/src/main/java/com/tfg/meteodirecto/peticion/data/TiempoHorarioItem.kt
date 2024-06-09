package com.tfg.meteodirecto.peticion.data

import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Origen2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Prediccion2

data class TiempoHorarioItem(
    val elaborado: String,
    val id: String,
    val nombre: String,
    val origen: Origen2,
    val prediccion: Prediccion2,
    val provincia: String,
    val version: String
)
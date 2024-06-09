package com.tfg.meteodirecto.peticion.data.dataTiempo

data class Temperatura(
    val dato: List<Dato>,
    val maxima: Int,
    val minima: Int
)
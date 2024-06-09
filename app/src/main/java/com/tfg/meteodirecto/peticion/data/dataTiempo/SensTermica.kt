package com.tfg.meteodirecto.peticion.data.dataTiempo

data class SensTermica(
    val dato: List<Dato>,
    val maxima: Int,
    val minima: Int
)
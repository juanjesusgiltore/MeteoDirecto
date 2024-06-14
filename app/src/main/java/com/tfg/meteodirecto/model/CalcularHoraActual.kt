package com.tfg.meteodirecto.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CalcularHoraActual {

    private val current = LocalDateTime.now()

    fun getHoraActual():String{
         val formatter = DateTimeFormatter.ofPattern("HH")
         return current.format(formatter).toString()
    }

    fun parsearHora(hora: String): String {
        return hora.substring(0, 2) + "-" + hora.substring(2, 4)
    }

}
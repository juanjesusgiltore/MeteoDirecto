package com.tfg.meteodirecto.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CalcularHoraActual {

    private val current = LocalDateTime.now()

    fun getHoraActual():String{
         val formatter = DateTimeFormatter.ofPattern("HH")
         return current.format(formatter).toString()
    }

}
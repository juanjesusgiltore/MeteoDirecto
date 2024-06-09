package com.tfg.meteodirecto.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CalcularHoraActual {

    fun getHoraActual():String{
         val current = LocalDateTime.now()
         val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
         val horaActual=current.format(formatter).substring(0,2)
        return horaActual
    }
}
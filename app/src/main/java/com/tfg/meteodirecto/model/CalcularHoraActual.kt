package com.tfg.meteodirecto.model

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class CalcularHoraActual {

    private val current = LocalDateTime.now()

    fun getHoraActual():String{
         val formatter = DateTimeFormatter.ofPattern("HH")
         return current.format(formatter).toString()
    }

    fun getTiempoActual(): String {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return dateFormat.format(Date())
    }

}
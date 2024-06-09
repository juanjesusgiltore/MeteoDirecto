package com.tfg.meteodirecto.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalcularDia {

    fun devolverFecha(fechaDia:String):String{
        var dia =""

        val fechaDia=fechaDia.substring(0,fechaDia.indexOf("T"))

        val fecha=LocalDate.parse(fechaDia , DateTimeFormatter.ISO_DATE)
        val hoy = LocalDate.now()
        val proximo = hoy.plusDays(1)

        val fechaComparar = if (fecha.isBefore(hoy.plusDays(7))) fecha else hoy.plusDays(7)

        when {
            fechaComparar == hoy -> dia="Hoy"
            fechaComparar == proximo -> dia="Mañana"
            fechaComparar.dayOfWeek == DayOfWeek.MONDAY -> dia="Lunes"
            fechaComparar.dayOfWeek == DayOfWeek.TUESDAY -> dia="Martes"
            fechaComparar.dayOfWeek == DayOfWeek.WEDNESDAY -> dia="Miércoles"
            fechaComparar.dayOfWeek == DayOfWeek.THURSDAY -> dia="Jueves"
            fechaComparar.dayOfWeek == DayOfWeek.FRIDAY -> dia="Viernes"
            fechaComparar.dayOfWeek == DayOfWeek.SATURDAY -> dia="Sábado"
            fechaComparar.dayOfWeek == DayOfWeek.SUNDAY -> dia="Domingo"
        }
        return dia
    }
}
package com.tfg.meteodirecto.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class CalcularDiaTest {

    private val calcularDia = CalcularDia()

    @Test
    fun `devolverFecha devuelve "Hoy" cuando la fecha es hoy`() {
        val hoy = LocalDate.now().toString()+"T"


        val resultado = calcularDia.devolverFecha(hoy)

        assertEquals("Hoy", resultado)
    }

    @Test
    fun `devolverFecha devuelve "Mañana" cuando la fecha es mañana`() {
        val mañana = LocalDate.now().plusDays(1).toString()+"T"

        val resultado = calcularDia.devolverFecha(mañana)

        assertEquals("Mañana", resultado)
    }


    @Test
    fun `devolverFecha devuelve el día de la semana correcto`() {
        val fecha = LocalDate.now().with(DayOfWeek.MONDAY).toString()+"T"

        val resultado = calcularDia.devolverFecha(fecha)

        assertEquals("Lunes", resultado)
    }

}
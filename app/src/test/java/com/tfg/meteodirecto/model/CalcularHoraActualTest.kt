package com.tfg.meteodirecto.model

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class CalcularHoraActualTest{

    private val calcularHoraActual = CalcularHoraActual()

    @Test
    fun `getHoraActual devuelve la hora actual en formato HH`() {
        val horaActualEsperada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH"))

        val horaActualObtenida = calcularHoraActual.getHoraActual()

        assertEquals(horaActualObtenida,horaActualEsperada)
    }

    @Test
    fun `parsearHora devuelve la hora formateada correctamente`() {
        val horaEntrada = "1230"
        val horaEsperada = "12-30"

        val horaParseada = calcularHoraActual.parsearHora(horaEntrada)

        assertEquals(horaParseada,horaEsperada)
    }
}
package com.tfg.meteodirecto.model

import org.junit.Assert.assertEquals
import org.junit.Test


class CalcularTemperaturaTest {


    private val calcularTemperatura = CalcularTemperatura()

    @Test
    fun `getTemperaturaActual devuelve la temperatura correcta para la hora actual`() {
        val lista = FuncionesTest().crearListaDeTiempoHorarioItem()
        val tiempoHorarioItem = lista[0]
        val horaActual = "12"

        val resultado = calcularTemperatura.getTemperaturaActual(tiempoHorarioItem, horaActual)
        assertEquals(resultado,"30")
    }

    @Test
    fun `getListaTemperatura devuelve la lista correcta de temperaturas para el primer dia y la hora actual`() {
        val lista =FuncionesTest().crearListaDeTiempoHorarioItem()
        val horaActual = "12"

        val resultado = calcularTemperatura.getListaTemperatura(lista, horaActual)

        assertEquals(resultado[0].value,"30")
    }


}
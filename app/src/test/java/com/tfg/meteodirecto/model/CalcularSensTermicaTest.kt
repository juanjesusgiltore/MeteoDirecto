package com.tfg.meteodirecto.model

import org.junit.Assert.assertEquals
import org.junit.Test


class CalcularSensTermicaTest{
    private val calcularSensTermica = CalcularSensTermica()

    @Test
    fun `getSensTermica devuelve la lista correcta de sensacion termica para el primer dia y la hora actual`() {
        val lista = FuncionesTest().crearListaDeTiempoHorarioItem()
        val horaActual = "12"

        val resultado = calcularSensTermica.getSensTermica(lista, horaActual)

        assertEquals(resultado[0].value,"15")
    }


    @Test
    fun `getSensacionActual devuelve la sensacion termica correcta para la hora actual`() {
        val lista = FuncionesTest().crearListaDeTiempoHorarioItem()
        val tiempoHorarioItem = lista[0]
        val horaActual = "12"

        val resultado = calcularSensTermica.getSensacionActual(tiempoHorarioItem, horaActual)
        assertEquals(resultado,"15")
    }
}
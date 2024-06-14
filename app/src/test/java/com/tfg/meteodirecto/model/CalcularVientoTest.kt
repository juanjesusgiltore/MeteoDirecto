package com.tfg.meteodirecto.model

import org.junit.Assert.assertEquals
import org.junit.Test


class CalcularVientoTest{
    private val calcularViento = CalcularViento()

    @Test
    fun `getDireccionViento devuelve la direccion correcta`() {
        assertEquals(calcularViento.getDireccionViento("N"),"Norte")
        assertEquals(calcularViento.getDireccionViento("NO"),"Noroste")
        assertEquals(calcularViento.getDireccionViento("NE"),"Noreste")
        assertEquals(calcularViento.getDireccionViento("S"),"Sur")
        assertEquals(calcularViento.getDireccionViento("O"),"Oeste")
        assertEquals(calcularViento.getDireccionViento("E"),"Este")
        assertEquals(calcularViento.getDireccionViento("SO"),"Suroste")
        assertEquals(calcularViento.getDireccionViento("SE"),"Sureste")
        assertEquals(calcularViento.getDireccionViento("X"),"Sin identificar")
    }

    @Test
    fun `getListaviento devuelve la lista correcta de viento para el primer dia y la hora actual`() {
        val lista = FuncionesTest().crearListaDeTiempoHorarioItem()
        val horaActual = "12"
        val prediccion = lista[0].prediccion

        val resultado = calcularViento.getListaviento(prediccion, horaActual)

        assertEquals(resultado[0].value,"10")
    }

}
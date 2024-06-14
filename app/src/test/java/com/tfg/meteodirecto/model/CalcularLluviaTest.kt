package com.tfg.meteodirecto.model

import org.junit.Test


class CalcularLluviaTest{

    @Test
    fun `getListaLluvia devuelve la lista correcta de precipitaciones para el primer dia y la hora actual`() {
        val calcularLluvia = CalcularLluvia()
        val lista = FuncionesTest().crearListaDeTiempoHorarioItem()
        val horaActual = "12"

        val resultado = calcularLluvia.getListaLluvia(lista, horaActual)

        assert(resultado[0].value.equals("0.5"))
    }

    @Test
    fun `getListaLluvia devuelve la lista correcta de precipitaciones para el segundo dia y la hora actual`() {
        val calcularLluvia = CalcularLluvia()
        val lista = FuncionesTest().crearListaDeTiempoHorarioItem()
        val horaActual = "06"

        val resultado = calcularLluvia.getListaLluvia(lista, horaActual)
       // assert(resultado.isNotEmpty())
       // assert(resultado.size==1)
        assert(resultado[0].value.equals("0.5"))
    }
}
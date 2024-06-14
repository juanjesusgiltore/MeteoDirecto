package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Dia2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.EstadoCielo2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.HumedadRelativa2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Origen2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Precipitacion
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Prediccion2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.ProbPrecipitacion2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.ProbTormenta
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.SensTermica2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Temperatura2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.VientoAndRachaMax
import org.junit.Assert.assertEquals
import org.junit.Test


class CalcularHumedadTest{

    private val calcularHumedad = CalcularHumedad()


    @Test
    fun `getListaHumedad devuelve la lista correcta de humedades`() {
        val lista = FuncionesTest().crearListaDeTiempoHorarioItem()
        val horaActual = "12"

        val resultado = calcularHumedad.getListaHumedad(lista, horaActual)
        println(resultado)
        assert(resultado .isNotEmpty())
    }

    @Test
    fun `getHumedadActual devuelve la humedad actual para el periodo dado`() {
        val tiempoHorarioItem = FuncionesTest().crearTiempoHorarioItemDePrueba()
        val horaActual = "12"

        val resultado = calcularHumedad.getHumedadActual(tiempoHorarioItem, horaActual)
        println(resultado)
        assertEquals(resultado ,"50")
    }


}
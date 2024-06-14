package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Prediccion2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.VientoAndRachaMax

class CalcularViento {

    fun getDireccionViento(viento:String):String{
        var direccion=""

        when(viento){
            "NO"->direccion="Noroste"
            "NE"->direccion="Noreste"
            "N"->direccion="Norte"
            "SO"->direccion="Suroste"
            "SE"->direccion="Sureste"
            "S"->direccion="Sur"
            "O"->direccion="Oeste"
            "E"->direccion="Este"
            else -> direccion="Sin identificar"
        }
        return direccion
    }

    fun getListaviento(viento:Prediccion2, horaActual: String):List<VientoAndRachaMax>{
        val lista = mutableListOf<VientoAndRachaMax>()

        viento.dia.forEachIndexed { diaIndex, dias ->

            dias.vientoAndRachaMax.forEach { viento ->
                if (diaIndex==0 && viento.periodo>=horaActual){
                    lista.add(viento)
                }
                if (diaIndex==1 && viento.periodo<horaActual){
                    lista.add(viento)
                }
            }
        }
        return lista
    }
}
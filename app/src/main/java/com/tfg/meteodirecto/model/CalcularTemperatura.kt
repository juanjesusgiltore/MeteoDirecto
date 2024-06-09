package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem


class CalcularTemperatura {



    fun getTemperaturaActual(tiempoHorarioItem: TiempoHorarioItem,horaActual:String):String{
        var temperatura=""
        tiempoHorarioItem.prediccion.dia[0].temperatura.forEach(){ temperaturas->
                if (temperaturas.periodo == horaActual){
                    temperatura=temperaturas.value
                }
            }
        return temperatura
    }
}
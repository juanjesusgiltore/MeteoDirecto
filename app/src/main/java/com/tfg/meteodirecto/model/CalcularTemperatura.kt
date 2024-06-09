package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Temperatura2


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

    fun getListaTemperatura(lista:List<TiempoHorarioItem>,horaActual: String):List<Temperatura2>{
        val listaData = mutableListOf<Temperatura2>()

        lista[0].prediccion.dia.forEachIndexed{diaIndex,dias->

            dias.temperatura.forEach { temperatura2 ->
                if (diaIndex==0 && temperatura2.periodo>=horaActual){
                    listaData.add(temperatura2)
                }
                if (diaIndex==1 && temperatura2.periodo<horaActual){
                    listaData.add(temperatura2)
                }
            }

        }
        return listaData
    }

}
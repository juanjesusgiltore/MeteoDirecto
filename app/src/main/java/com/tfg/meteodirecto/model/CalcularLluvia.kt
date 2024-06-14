package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.HumedadRelativa2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Precipitacion
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.ProbPrecipitacion2

class CalcularLluvia {

    fun getListaLluvia(lista:List<TiempoHorarioItem>, horaActual: String):List<Precipitacion>{
        val listaData = mutableListOf<Precipitacion>()

        lista[0].prediccion.dia.forEachIndexed{diaIndex,dias->

            dias.precipitacion.forEach { probPrecipitacion2 ->
                if (diaIndex==0 && probPrecipitacion2.periodo>=horaActual){
                    listaData.add(probPrecipitacion2)
                }
                if (diaIndex==1 && probPrecipitacion2.periodo<horaActual){
                    listaData.add(probPrecipitacion2)
                }
            }

        }
        return listaData
    }
}
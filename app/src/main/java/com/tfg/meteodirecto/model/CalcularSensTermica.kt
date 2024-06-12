package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.SensTermica2

class CalcularSensTermica {

    fun getSensTermica(lista:List<TiempoHorarioItem>, horaActual: String):List<SensTermica2>{
        val listaData = mutableListOf<SensTermica2>()

        lista[0].prediccion.dia.forEachIndexed{diaIndex,dias->

            dias.sensTermica.forEach { sensTermica ->
                if (diaIndex==0 && sensTermica.periodo>=horaActual){
                    listaData.add(sensTermica)
                }
                if (diaIndex==1 && sensTermica.periodo<horaActual){
                    listaData.add(sensTermica)
                }
            }

        }
        return listaData
    }

    fun getSensacionActual(tiempoHorarioItem: TiempoHorarioItem,horaActual:String):String{
        var sensacion=""
        tiempoHorarioItem.prediccion.dia[0].sensTermica.forEach(){ sens->
            if (sens.periodo == horaActual){
                sensacion=sens.value
            }
        }
        return sensacion

    }
}
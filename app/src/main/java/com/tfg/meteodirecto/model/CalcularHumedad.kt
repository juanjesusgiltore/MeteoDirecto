package com.tfg.meteodirecto.model

import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.HumedadRelativa2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Temperatura2

class CalcularHumedad {


    fun devolerImagen(humedadRelativa: Int):Int{

        var painter =0

        when{
            humedadRelativa  <=25 ->painter= R.drawable.humidity_low_24dp_fill0_wght400_grad0_opsz24
            humedadRelativa  <=75 -> painter=R.drawable.humidity_mid_24dp_fill0_wght400_grad0_opsz24
            humedadRelativa >75 -> painter=R.drawable.humidity_high_24dp_fill0_wght400_grad0_opsz24
        }
        return painter
    }

    fun getListaHumedad(lista:List<TiempoHorarioItem>, horaActual: String):List<HumedadRelativa2>{
        val listaData = mutableListOf<HumedadRelativa2>()

        lista[0].prediccion.dia.forEachIndexed{diaIndex,dias->

            dias.humedadRelativa.forEach { humedadRelativa2 ->
                if (diaIndex==0 && humedadRelativa2.periodo>=horaActual){
                    listaData.add(humedadRelativa2)
                }
                if (diaIndex==1 && humedadRelativa2.periodo<horaActual){
                    listaData.add(humedadRelativa2)
                }
            }

        }
        return listaData
    }
}
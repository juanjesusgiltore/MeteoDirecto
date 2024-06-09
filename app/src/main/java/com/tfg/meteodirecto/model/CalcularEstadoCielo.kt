package com.tfg.meteodirecto.model

import android.util.Log
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.EstadoCielo2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.HumedadRelativa2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.ProbPrecipitacion2

class CalcularEstadoCielo {

    fun getEstadoCieloIcono(estadoCielo: String): Int {

        val estado: Int

        when (estadoCielo) {
            "Despejado" -> estado = R.drawable.sunny_24dp_fill0_wght400_grad0_opsz24
            "Despejado Noche" -> estado = R.drawable.clear_night_24dp_fill0_wght400_grad0_opsz24
            "Intervalos Nubosos Noche" -> estado =
                R.drawable.nights_stay_24dp_fill0_wght400_grad0_opsz24

            "Nuboso Noche" -> estado = R.drawable.nights_stay_24dp_fill0_wght400_grad0_opsz24
            "Niebla" -> estado = R.drawable.mist_24dp_fill0_wght400_grad0_opsz24
            "Nubloso" -> estado = R.drawable.cloud_24dp_fill0_wght400_grad0_opsz24
            "Intervalos nubosos" -> estado =
                R.drawable.cloud_24dp_fill0_wght400_grad0_opsz24

            "Poco nuboso" -> estado = R.drawable.cloud_24dp_fill0_wght400_grad0_opsz24
            "Poco nuboso con lluvia" -> estado = R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24
            "Poco nuboso con lluvia escasa" -> estado =
                R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24

            "Cubierto" -> estado = R.drawable.cloud_24dp_fill0_wght400_grad0_opsz24
            "Cubierto con lluvia" -> estado = R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24
            "Cubierto con lluvia escasa" -> estado =
                R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24

            "Cubierto con nieve" -> estado =
                R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24

            "Cubierto con nieve escasa" -> estado =
                R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24

            "Nuboso con lluvia" -> estado = R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24
            "Nuboso con lluvia escasa" -> estado = R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24
            "Nuboso con nieve" -> estado = R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24
            "Nuboso con nieve escasa" -> estado =
                R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24
            "Nubes altas"-> estado = R.drawable.cloud_24dp_fill0_wght400_grad0_opsz24
            "Muy nuboso" -> estado = R.drawable.cloud_24dp_fill0_wght400_grad0_opsz24
            "Muy nuboso con lluvia" -> estado = R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24
            "Muy nuboso con lluvia escasa" -> estado =
                R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24

            "Muy nuboso con nieve" -> estado =
                R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24

            "Muy nuboso con nieve escasa" -> estado =
                R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24

            "Intervalos nubosos con lluvia escasa" -> estado =
                R.drawable.rainy_24dp_fill0_wght400_grad0_opsz24

            "Intervalos nubosos con nieve escasa" -> estado =
                R.drawable.cloudy_snowing_24dp_fill0_wght400_grad0_opsz24

            "Tormenta" -> estado = R.drawable.thunderstorm_24dp_fill0_wght400_grad0_opsz24
            else -> estado = R.drawable.sunny_24dp_fill0_wght400_grad0_opsz24
        }

        return estado
    }

    fun getEstadoCieloCard(horaActual: String, tiempo: TiempoHorarioItem): Int {
        var id = 0

        tiempo.prediccion.dia[0].estadoCielo.forEach { estadoCielo2 ->
            if (estadoCielo2.periodo == horaActual) {
                Log .i("estado",estadoCielo2.descripcion)
                when (estadoCielo2.descripcion) {
                    "Despejado" -> id = R.drawable.dm4uz3foekoe
                    "Despejado Noche" -> id = R.drawable.fullmoon
                    "Intervalos Nubosos Noche" -> id = R.drawable.nubes
                    "Nuboso Noche" -> id = R.drawable.nubes
                    "Niebla" -> id = R.drawable.fourwindfourwindfilms
                    "Nubloso" -> id = R.drawable.nubes
                    "Intervalos nubosos" -> id = R.drawable.nubes
                    "Poco nuboso" -> id = R.drawable.nubes
                    "Poco nuboso con lluvia" -> id = R.drawable.nubes
                    "Poco nuboso con lluvia escasa" -> id = R.drawable.nubes
                    "Cubierto" -> id = R.drawable.nubes
                    "Nubes altas"-> id = R.drawable.nubes
                    "Cubierto con lluvia" -> id = R.drawable.cloudyraining
                    "Cubierto con lluvia escasa" -> id = R.drawable.cloudyraining
                    "Cubierto con nieve" -> id = R.drawable.ezosnowflakes
                    "Cubierto con nieve escasa" -> id = R.drawable.ezosnowflakes
                    "Nuboso con lluvia" -> id = R.drawable.cloudyraining
                    "Nuboso con lluvia escasa" -> id = R.drawable.cloudyraining
                    "Nuboso con nieve" -> id = R.drawable.ezosnowflakes
                    "Nuboso con nieve escasa" -> id = R.drawable.ezosnowflakes
                    "Muy nuboso" -> id = R.drawable.nubes
                    "Muy nuboso con lluvia" -> id = R.drawable.cloudyraining
                    "Muy nuboso con lluvia escasa" -> id = R.drawable.cloudyraining
                    "Muy nuboso con nieve" -> id = R.drawable.ezosnowflakes
                    "Muy nuboso con nieve escasa" -> id = R.drawable.ezosnowflakes
                    "Intervalos nubosos con lluvia escasa" -> id = R.drawable.cloudyraining
                    "Intervalos nubosos con nieve escasa" -> id = R.drawable.cloudyraining
                    "Tormenta" -> id = R.drawable.tormenta
                    else -> id = R.drawable.dm4uz3foekoe

                }
            }

        }
        return id
    }
    fun getEstadoCielo(horaActual: String, tiempo: TiempoHorarioItem): EstadoCielo2? {
        var estadoCielo: EstadoCielo2? =null
        tiempo.prediccion.dia[0].estadoCielo.forEach { estadoCielo2 ->
            if (estadoCielo2.periodo==horaActual) estadoCielo=estadoCielo2
        }

        return estadoCielo
    }
    fun getListaEstadoCielo(lista:List<TiempoHorarioItem>, horaActual: String):List<EstadoCielo2>{
        val listaData = mutableListOf<EstadoCielo2>()

        lista[0].prediccion.dia.forEachIndexed{diaIndex,dias->

            dias.estadoCielo.forEach { estado ->
                if (diaIndex==0 && estado.periodo>=horaActual){
                    listaData.add(estado)
                }
                if (diaIndex==1 && estado.periodo<horaActual){
                    listaData.add(estado)
                }
            }

        }
        return listaData
    }
}
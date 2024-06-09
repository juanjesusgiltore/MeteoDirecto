package com.tfg.meteodirecto.peticion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfg.meteodirecto.model.CalcularHoraActual
import com.tfg.meteodirecto.model.CalcularTemperatura
import com.tfg.meteodirecto.model.EstadoCielo
import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.EstadoCielo2
import com.tfg.meteodirecto.peticion.retrofit.tiempo2.InstanciaRetrofitTiempo2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeticionTiempo2ViewModel :ViewModel() {

    private val _tiempo= MutableLiveData<List<TiempoHorarioItem>>()

    val tiempo: LiveData<List<TiempoHorarioItem>> =_tiempo


    fun getTiempo(url:String){
        val baseurl=url.substring(0,url.lastIndexOf("/")+1)
        val endpoint=url.substring(url.lastIndexOf("/")+1)
        Log.i("End",endpoint)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = InstanciaRetrofitTiempo2.getRetrofitTiempo2(baseurl).getTiempo(endpoint)
                Log.i("Pasa",response.body().toString())
                if (response.isSuccessful) {
                    Log.i("Peti2",response.body().toString())
                    _tiempo.postValue(response.body())
                }
            }catch (e:Exception){
                Log.e("Exepcion","peto",e)
            }
        }
    }
    fun getTemperatura(tiempo: TiempoHorarioItem):String{
        return CalcularTemperatura().getTemperaturaActual(tiempo,getHoraActual())
    }
    fun getEstadoCielo(tiempo: TiempoHorarioItem): Int {
        return EstadoCielo().getEstadoCieloCard(getHoraActual(),tiempo)
    }
    fun getHoraActual():String{
        return CalcularHoraActual().getHoraActual()
    }
    fun getEstado(tiempo: TiempoHorarioItem):EstadoCielo2?{
        return EstadoCielo().getEstadoCielo(getHoraActual(),tiempo)
    }
}
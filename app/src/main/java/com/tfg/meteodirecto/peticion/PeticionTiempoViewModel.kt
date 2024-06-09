package com.tfg.meteodirecto.peticion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfg.meteodirecto.model.CalcularHumeda
import com.tfg.meteodirecto.model.EstadoCielo
import com.tfg.meteodirecto.peticion.data.TiempoItem
import com.tfg.meteodirecto.peticion.data.dataTiempo.Dia
import com.tfg.meteodirecto.peticion.retrofit.tiempo.InstanciaRetrofitTiempo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeticionTiempoViewModel():ViewModel() {

    private val _tiempo=MutableLiveData<List<TiempoItem>>()

    val tiempo:LiveData<List<TiempoItem>> =_tiempo


    fun getTiempo(url:String){
        val baseurl=url.substring(0,url.lastIndexOf("/")+1)
        val endpoint=url.substring(url.lastIndexOf("/")+1)
        Log.i("End",endpoint)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = InstanciaRetrofitTiempo.getRetrofitTiempo(baseurl).getTiempo(endpoint)
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

    fun getEstadoCielo(dia: Dia):Int{
        return EstadoCielo().getEstadoCieloIcono(dia.estadoCielo[0].descripcion)
    }
    fun getHumedad(dia:Dia):Int{
        return CalcularHumeda().devolerImagen(dia.humedadRelativa.maxima)
    }

}
package com.tfg.meteodirecto.peticion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfg.meteodirecto.model.CalcularHoraActual
import com.tfg.meteodirecto.model.CalcularHumedad
import com.tfg.meteodirecto.model.CalcularLluvia
import com.tfg.meteodirecto.model.CalcularSensTermica
import com.tfg.meteodirecto.model.CalcularTemperatura
import com.tfg.meteodirecto.model.CalcularEstadoCielo
import com.tfg.meteodirecto.model.CalcularViento
import com.tfg.meteodirecto.peticion.data.TiempoHorarioItem
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.EstadoCielo2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.HumedadRelativa2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Precipitacion
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.SensTermica2
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.Temperatura2
import com.tfg.meteodirecto.peticion.retrofit.tiempo2.InstanciaRetrofitTiempo2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeticionTiempo2ViewModel :ViewModel() {

    private val _tiempo= MutableLiveData<List<TiempoHorarioItem>>()

    val tiempo: LiveData<List<TiempoHorarioItem>> =_tiempo

    private val _temperatura= MutableLiveData<List<Temperatura2>>()

    val temperatura: LiveData<List<Temperatura2>> =_temperatura

    private val _lluvia= MutableLiveData<List<Precipitacion>>()

    val lluvia: LiveData<List<Precipitacion>> =_lluvia

    private val _sensTermica= MutableLiveData<List<SensTermica2>>()

    val sensTermica: LiveData<List<SensTermica2>> =_sensTermica

    private val _humedad=MutableLiveData<List<HumedadRelativa2>>()

    val humedad:LiveData<List<HumedadRelativa2>> =_humedad

    private val _estado=MutableLiveData<List<EstadoCielo2>>()

    val estado:LiveData<List<EstadoCielo2>> =_estado

    private val _temperaturaActual=MutableLiveData<String>()

    val temperaturaActual:LiveData<String> =_temperaturaActual

    private val _estadoCielo=MutableLiveData<Int>()

    val estadoCielo:LiveData<Int> =_estadoCielo

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
    fun getTemperatura(tiempo: TiempoHorarioItem){
        _temperaturaActual.postValue(CalcularTemperatura().getTemperaturaActual(tiempo,getHoraActual()))
    }
    fun getEstadoCielo(tiempo: TiempoHorarioItem) {
        _estadoCielo.postValue(CalcularEstadoCielo().getEstadoCieloCard(getHoraActual(),tiempo))
    }
    private fun getHoraActual():String{
        return CalcularHoraActual().getHoraActual()
    }
    fun getEstado(tiempo: TiempoHorarioItem):EstadoCielo2?{
        return CalcularEstadoCielo().getEstadoCielo(getHoraActual(),tiempo)
    }
    fun getEstadoIcono(estadoCielo: String):Int{
        return CalcularEstadoCielo().getEstadoCieloIcono(estadoCielo)
    }
    fun getListaHumedad() {
        _tiempo.value?.let {
            _humedad.postValue(CalcularHumedad().getListaHumedad(it, getHoraActual()))
        }
    }

    fun getListaSensacion() {
        _tiempo.value?.let {
            _sensTermica.postValue(CalcularSensTermica().getSensTermica(it, getHoraActual()))
        }
    }
    fun getListaLluvia() {
        _tiempo.value?.let {
            _lluvia.postValue(CalcularLluvia().getListaLluvia(it, getHoraActual()))
        }
    }
    fun getListaTemperatura() {
        _tiempo.value?.let {
            _temperatura.postValue(CalcularTemperatura().getListaTemperatura(it,getHoraActual()))
        }
    }
    fun getListaEstado() {
        _tiempo.value?.let {
            _estado.postValue(CalcularEstadoCielo().getListaEstadoCielo(it,getHoraActual()))
        }
    }
    fun getIconoHumedad(humedadRelativa: Int):Int{
        return CalcularHumedad().devolerImagen(humedadRelativa)
    }
    fun getViento(viento:String):String{
        return CalcularViento().getDireccionViento(viento)
    }

}
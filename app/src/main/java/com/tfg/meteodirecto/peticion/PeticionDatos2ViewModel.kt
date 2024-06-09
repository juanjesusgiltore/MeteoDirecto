package com.tfg.meteodirecto.peticion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfg.meteodirecto.peticion.data.Datos
import com.tfg.meteodirecto.peticion.retrofit.datos2.InstanciaRetrofitDatos2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeticionDatos2ViewModel():ViewModel() {
    private val apiKey="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuamVzdXNnaWx0b3JlN0BnbWFpbC5jb20iLCJqdGkiOiJhZDMzYWNjOC05NTM0LTQzNWMtYjRjMS00ZThjN2NiZDdiMDAiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY5ODM0Njc4OCwidXNlcklkIjoiYWQzM2FjYzgtOTUzNC00MzVjLWI0YzEtNGU4YzdjYmQ3YjAwIiwicm9sZSI6IiJ9.wQ61veYdrJQU5H1LOpI8bkspxXjrIAWSwoV1Q8gQ9dU"

    private val _datos= MutableLiveData<Datos>()

    val datos: LiveData<Datos> =_datos

    fun getDatos(codMun:String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.i("Peti0", codMun)
                val response = InstanciaRetrofitDatos2.getRetrofitDatos2().getPeticion(apiKey, codMun)
                Log.i("Peti1", response.body().toString())
                if (response.isSuccessful) {
                    Log.i("Peti", response.body().toString())
                    _datos.postValue(response.body())
                }
            }catch (e:Exception){

            }
        }
    }
}
package com.tfg.meteodirecto.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfg.meteodirecto.database.entities.Localidades
import com.tfg.meteodirecto.database.interfaces.InterfazDaoLocalidades
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.SQLException

class DatabaseLocalidadesViewModel(context: Context):ViewModel() {

    private val miDaoLocalidades: InterfazDaoLocalidades


    private val _todasLasLocalidades=MutableLiveData<List<Localidades>>(emptyList())
    val todasLasLocalidades:LiveData<List<Localidades>> =_todasLasLocalidades

    private val _localidadgps=MutableLiveData<Localidades>()
    val localidadgps:LiveData<Localidades> =_localidadgps


    private val _flag=MutableLiveData(false)
    val flag:LiveData<Boolean> =_flag

    private val _localgps= MutableLiveData<String>()
    val localgps:LiveData<String> = _localgps


    init {
        val database = BaseDeDatos.getDatabase(context)
        miDaoLocalidades = database.localidadesDao()

    }

    fun getlistlocalidades(){
        viewModelScope.launch(Dispatchers.IO) {
            _todasLasLocalidades.postValue( miDaoLocalidades.getAllLocalidades())
            if(_todasLasLocalidades.value?.isNotEmpty() == true){
                _flag.postValue(true)
            }
        }
    }

    fun insertarGps(nombre:String){
        _localgps.postValue(nombre)
    }
    fun getLocalidad(nombre: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _localidadgps.postValue(miDaoLocalidades.getLocalidad(nombre))
            }catch (e:SQLException){
                Log.e("E","exepcion",e)
            }
        }
    }
}
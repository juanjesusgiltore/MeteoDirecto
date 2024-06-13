package com.tfg.meteodirecto.database

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.database.entities.Localidades
import com.tfg.meteodirecto.database.interfaces.InterfazDaoFavoritos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DatabaseFavoritoViewModel(context: Context):ViewModel() {

    private val miDaoFavoritos: InterfazDaoFavoritos


    private val _todasLosFavoritos= MutableLiveData<List<Favoritos>>(emptyList())
    val todasLosFavoritos: LiveData<List<Favoritos>> =_todasLosFavoritos

    private val _isSelected=MutableLiveData<Map<Favoritos,Boolean>>(emptyMap())
    val isSelected:LiveData<Map<Favoritos,Boolean>> =_isSelected

    private val _flag=MutableLiveData(false)
    val flag:LiveData<Boolean> =_flag

    private val _favoritogps= MutableLiveData<Favoritos>()


    init {
        val database = BaseDeDatos.getDatabase(context)
        miDaoFavoritos = database.favoritosDao()
        getlistfavoritos()
    }

    fun getlistfavoritos(){
        viewModelScope.launch(Dispatchers.IO) {
            val favoritosList = miDaoFavoritos.getAllFavoritos()
            _todasLosFavoritos.postValue(favoritosList)
            actualizarSeleccion(favoritosList)
        }
    }

    fun insertarFavorito(favoritos: Favoritos){
        Log.i("vm",favoritos.toString())
        val existente = _todasLosFavoritos.value?.any { it == favoritos } ?: false
        if (existente) {
            _flag.postValue(false)
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    miDaoFavoritos.insertarFavorito(favoritos)
                    _flag.postValue(true)
                    val updatedList = miDaoFavoritos.getAllFavoritos()
                    _todasLosFavoritos.postValue(updatedList)
                    actualizarSeleccion(updatedList)
                    cambioSelecionado(favoritos)
                } catch (e: SQLiteConstraintException) {
                    Log.e("SQLiteConstraintException", "Error de restricción de unicidad", e)
                    _flag.postValue(false)
                }
            }
        }
    }
    fun eliminarFavorito(favorito: Favoritos){
        viewModelScope.launch(Dispatchers.IO) {
            miDaoFavoritos.eliminarFavorito(favorito)
            val updatedList = _todasLosFavoritos.value?.filter { it != favorito }
            _todasLosFavoritos.postValue(updatedList!!)
            actualizarSeleccion(updatedList)
        }
    }

    fun cambioSelecionado(favorito: Favoritos){
        viewModelScope.launch(Dispatchers.IO) {

            val updatedList = _todasLosFavoritos.value?.map {
                if (it == favorito) it.copy(isSelected = 1) else it.copy(isSelected = 0)
            } ?: emptyList()

            updatedList.forEach { miDaoFavoritos.actualizarFavorito(it) }

            _todasLosFavoritos.postValue(updatedList)
            actualizarSeleccion(updatedList)
        }
    }

    private fun actualizarSeleccion(favoritosList: List<Favoritos>) {
        val updateMap: MutableMap<Favoritos, Boolean> = favoritosList.associateWith { it.isSelected == 1 }.toMutableMap()
        _isSelected.postValue(updateMap)
    }

    fun setFavoritos(){
         _flag.postValue(false)
    }

    fun insertarLocalidadGPS(localidad:Localidades){
        val favorito = Favoritos(
            CODAUTO = localidad.CODAUTO,
            CPRO = localidad.CPRO,
            CMUN = localidad.CMUN,
            DC = localidad.DC,
            NOMBRE = localidad.NOMBRE,
            isSelected = 1,
        )
        if (_favoritogps.value!=favorito) {
            _favoritogps.postValue(favorito)
            insertarFavorito(favorito)
        }
    }
}

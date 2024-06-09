package com.tfg.meteodirecto.elements

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel

@Composable
fun Tabla(
    peticionDatosViewModel: PeticionDatosViewModel,
    peticionTiempoViewModel: PeticionTiempoViewModel,
    favoritos: Favoritos
) {
    val datos by peticionDatosViewModel .datos .observeAsState()
    val tiempo by peticionTiempoViewModel .tiempo.observeAsState()

    LaunchedEffect(favoritos) {
        peticionDatosViewModel.getDatos(favoritos.CPRO+favoritos.CMUN)
    }
    LaunchedEffect(datos) {
        datos?.let { peticionTiempoViewModel.getTiempo(it.datos)  }
    }


    tiempo?.let {
        Log.i("estado1" ,tiempo.toString())
        Column(
        ) {
            it[0].prediccion.dia.forEach { dia ->
                FilaTabla(dia, peticionTiempoViewModel)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }?: run {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

}
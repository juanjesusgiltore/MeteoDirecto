package com.tfg.meteodirecto.elements

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel

@Composable
fun Tabla(
    peticionDatosViewModel: PeticionDatosViewModel,
    peticionTiempoViewModel: PeticionTiempoViewModel,
    favoritos: Favoritos,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel
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

        Box(modifier =Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.outline,
                shape= RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
        ) {
            Column {
                it[0].prediccion.dia.forEach { dia ->
                    FilaTabla(dia, peticionTiempoViewModel,peticionTiempo2ViewModel)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }?: run {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

}
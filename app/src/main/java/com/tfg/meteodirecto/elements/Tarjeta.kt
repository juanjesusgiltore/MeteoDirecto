package com.tfg.meteodirecto.elements

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel

@Composable
fun Tarjeta(
    peticionDatos2ViewModel: PeticionDatos2ViewModel,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
    favoritos: Favoritos,
) {
    val datos by peticionDatos2ViewModel.datos.observeAsState()
    val tiempo by peticionTiempo2ViewModel.tiempo.observeAsState()

    LaunchedEffect(favoritos) {
        peticionDatos2ViewModel.getDatos(favoritos.CPRO+favoritos.CMUN)
    }
    LaunchedEffect(datos) {
        datos?.let { peticionTiempo2ViewModel.getTiempo(it.datos) }
    }

    tiempo?.let {
        val temperaturaActual = peticionTiempo2ViewModel.getTemperatura(it[0])
        val estadoCielo = peticionTiempo2ViewModel.getEstadoCielo(it[0])
        val estado = peticionTiempo2ViewModel.getEstado(it[0])
        val painter = rememberAsyncImagePainter(model = estadoCielo)

        Log.i("estado", estadoCielo.toString())
        Column {
            Text(text = it[0].nombre)
            HorizontalDivider(thickness = 2.dp , color = Color.Black)
            Box {
                Column {
                    Row {
                        Text(text = temperaturaActual + "º")
                        Spacer(modifier = Modifier.weight(1f))
                        Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painter,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Row {
                        Text(text = estado!!.descripcion)
                    }
                }
            }
            }
    } ?: run {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}




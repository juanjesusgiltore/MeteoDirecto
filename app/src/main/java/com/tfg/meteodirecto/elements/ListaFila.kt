package com.tfg.meteodirecto.elements

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel

@Composable
fun ListaFila(
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
) {
    val tiempo by peticionTiempo2ViewModel .tiempo.observeAsState()
    val temperatura by peticionTiempo2ViewModel.temperatura.observeAsState()
    val humedad by peticionTiempo2ViewModel.humedad.observeAsState()
    val sensTermica by peticionTiempo2ViewModel.sensTermica.observeAsState()
    val lluvia by peticionTiempo2ViewModel.lluvia.observeAsState()
    val estado by peticionTiempo2ViewModel.estado.observeAsState()

    LaunchedEffect(tiempo) {
        tiempo?.let {
            peticionTiempo2ViewModel.getListaTemperatura()
            peticionTiempo2ViewModel.getListaHumedad()
            peticionTiempo2ViewModel.getListaSensacion()
            peticionTiempo2ViewModel.getListaLluvia()
            peticionTiempo2ViewModel.getListaEstado()
        }
    }

    temperatura?.let {
        Log.i("listas", temperatura!!.size.toString()+"temperatura")
        Log.i("listas", humedad!!.size.toString()+"humedad")
        Log.i("listas", sensTermica!!.size.toString()+"senstermica")
        Log.i("listas", lluvia!!.size.toString()+"lluvia")
        Log.i("listas", estado!!.size.toString()+"estadp")

        LazyRow {
                items(it.size){numero ->
                    ElementoFila(it[numero], humedad!![numero],
                        sensTermica!![numero], lluvia!![numero],estado!![numero],
                        peticionTiempo2ViewModel)
                    Spacer(modifier = Modifier.width(16.dp))
                }

            }
        }?: run {
        CircularProgressIndicator()
    }
}

package com.tfg.meteodirecto.elements

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.ImageDecoderDecoder
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.data.dataTiempoHorario.EstadoCielo2

@SuppressLint("SuspiciousIndentation")
@Composable
fun Tarjeta(
    peticionDatos2ViewModel: PeticionDatos2ViewModel,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
    favoritos: Favoritos,
) {
    val datos by peticionDatos2ViewModel.datos.observeAsState()
    val tiempo by peticionTiempo2ViewModel.tiempo.observeAsState()
    val temperaturaActual by peticionTiempo2ViewModel.temperaturaActual.observeAsState()
    val estadoCielo by peticionTiempo2ViewModel.estadoCielo.observeAsState()
    val sensActual by peticionTiempo2ViewModel.sensActual.observeAsState()
    val humActual by peticionTiempo2ViewModel.humedadActual.observeAsState()
    var estado:EstadoCielo2?

    LaunchedEffect(favoritos) {
        peticionDatos2ViewModel.getDatos(favoritos.CPRO+favoritos.CMUN)
    }
    LaunchedEffect(datos) {
        datos?.let { peticionTiempo2ViewModel.getTiempo(it.datos) }
    }

    tiempo?.let {
        peticionTiempo2ViewModel.getTemperatura(it[0])
        peticionTiempo2ViewModel.getEstadoCielo(it[0])
        peticionTiempo2ViewModel.getSensacion(it[0])
        peticionTiempo2ViewModel.getHumedad(it[0])
        estado = peticionTiempo2ViewModel.getEstado(it[0])

    estadoCielo?.let { imagen ->
        estado?.let { estadoit ->
            val context = LocalContext.current
            val imageLoader = ImageLoader.Builder(context)
                .components {
                    add(ImageDecoderDecoder.Factory())
                }
                .build()
            val painter= rememberAsyncImagePainter(
                model = imagen,
                imageLoader = imageLoader
            )
            Log.i("estado", estadoCielo.toString())
            Column {
                Text(text = tiempo!![0].nombre)
                HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.secondary)
                Box {
                    Column(

                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = temperaturaActual + "º",
                                    fontSize = 50.sp,
                                    textAlign = TextAlign.Center
                                    )
                                Text(
                                    text = stringResource(id = R.string.senstermica)+" "+sensActual + "º",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = stringResource(id = R.string.humedad)+" "+humActual+ "%",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))

                            Box(
                                modifier = Modifier.size(150.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter =painter ,

                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                        }
                        Row {
                            Text(text = estadoit.descripcion)
                        }
                    }
                }
            }
        }
    }
    } ?: run {
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




package com.tfg.meteodirecto.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel

@Composable
fun Viento(
    peticionDatosViewModel: PeticionDatos2ViewModel,
    peticionTiempoViewModel: PeticionTiempo2ViewModel,
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
        val viento=peticionTiempoViewModel.getViento(it[0].prediccion.dia[0].vientoAndRachaMax[0].direccion[0])
        Box {
            Column {
                Text(text = stringResource(id = R.string.viento))
                HorizontalDivider(thickness = 2.dp, color = Color.Black)
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.air_24dp_fill0_wght400_grad0_opsz24),
                        contentDescription = "viento"
                    )

                    Text(
                        text = stringResource(id = R.string.direccion)+" " + viento + " "
                                + it[0].prediccion.dia[0].vientoAndRachaMax[0].velocidad[0] + " Km/h"
                    )
                }
            }
        }
    }
}
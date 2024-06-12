package com.tfg.meteodirecto.elements

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
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
    peticionTiempoViewModel: PeticionTiempo2ViewModel,
) {
    val tiempo by peticionTiempoViewModel .tiempo.observeAsState()




    tiempo?.let {
        val viento=peticionTiempoViewModel.getViento(it[0].prediccion.dia[0].vientoAndRachaMax[0].direccion[0])
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape= RoundedCornerShape(16.dp)
                )
                .padding(8.dp)
        ) {
            Column {
                Text(text = stringResource(id = R.string.viento))
                HorizontalDivider(thickness = 2.dp, color =MaterialTheme.colorScheme.outlineVariant)
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
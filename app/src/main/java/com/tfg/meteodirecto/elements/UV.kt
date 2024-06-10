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
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel

@Composable
fun Uvmax(
    peticionTiempoViewModel: PeticionTiempoViewModel,
) {
    val tiempo by peticionTiempoViewModel .tiempo.observeAsState()



    tiempo?.let {
        Box {
            Column {
                Text(text = stringResource(id = R.string.uv))
                HorizontalDivider(thickness = 2.dp, color = Color.Black)
                Row {
                    Text(
                        text = it[0].prediccion.dia[0].uvMax.toString()
                    )
                }
            }
        }
    }
}
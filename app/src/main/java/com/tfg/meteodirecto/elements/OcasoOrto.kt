package com.tfg.meteodirecto.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.R
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel

@Composable
fun OcasoOrto(
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
) {
    val tiempo by peticionTiempo2ViewModel.tiempo.observeAsState()



    tiempo?.let {
        Box {
            Column {
                Text(text = stringResource(id = R.string.ocasoorto))
                HorizontalDivider(thickness = 2.dp, color = Color.Black)
                Row {
                    Text(text = "Amanece "+it[0].prediccion.dia[0].orto)
                }
                Row {
                    Text(text = "Atardece "+it[0].prediccion.dia[0].ocaso)

                }
            }
        }
    }
}
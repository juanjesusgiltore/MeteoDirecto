package com.tfg.meteodirecto.elements

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(16.dp)
                )

                .padding(8.dp)
        ) {
            Column {
                Text(text = stringResource(id = R.string.ocasoorto))
                HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
                   Row {
                       Text(text = "Amanece " + it[0].prediccion.dia[0].orto)
                       Spacer(modifier = Modifier.width(16.dp))
                       Icon(painter = painterResource(id = R.drawable.sunny_24dp_fill0_wght400_grad0_opsz24) , contentDescription ="amanece" )
                   }
                Row {
                    Text(text = "Atardece " + it[0].prediccion.dia[0].ocaso)
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(painter = painterResource(id = R.drawable.clear_night_24dp_fill0_wght400_grad0_opsz24) , contentDescription ="atardece" )

                }

            }
        }
    }
}
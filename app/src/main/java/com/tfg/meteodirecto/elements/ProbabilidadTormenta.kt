package com.tfg.meteodirecto.elements

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel

@Composable
fun ProbabilidadTormenta(peticionTiempo2ViewModel: PeticionTiempo2ViewModel){

    val tiempo by peticionTiempo2ViewModel.tiempo.observeAsState()
    tiempo?.let {

    Box(modifier = Modifier
        .border( width = 2.dp,
            color = MaterialTheme.colorScheme.outline,
            shape= RoundedCornerShape(16.dp)
        )
        .padding(8.dp)

    ){
        Column {
            Text(text = peticionTiempo2ViewModel.getDias(it[0].prediccion.dia[0].fecha))
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
            LazyRow {
                items(it[0].prediccion.dia[0].probTormenta) { probab ->
                    ElementoTormenta(probab, peticionTiempo2ViewModel)
                    Spacer(modifier = Modifier.width(16.dp))
                }

            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = peticionTiempo2ViewModel.getDias(it[0].prediccion.dia[1].fecha))
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
            LazyRow {
                items(it[0].prediccion.dia[1].probTormenta) { probab ->
                    ElementoTormenta(probab, peticionTiempo2ViewModel)
                    Spacer(modifier = Modifier.width(16.dp))
                }

            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = peticionTiempo2ViewModel.getDias(it[0].prediccion.dia[2].fecha))
            HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.outlineVariant)
            LazyRow {
                items(it[0].prediccion.dia[2].probTormenta) { probab ->
                    ElementoTormenta(probab, peticionTiempo2ViewModel)
                    Spacer(modifier = Modifier.width(16.dp))
                }

            }
        }
    }

    }?:run {
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
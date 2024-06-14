package com.tfg.meteodirecto.elements

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel

@Composable
fun Viento(
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel,
) {
    val tiempo by peticionTiempo2ViewModel .tiempo.observeAsState()


    tiempo?.let {
        val viento = peticionTiempo2ViewModel.getListaViento(it[0].prediccion)

        viento.let {
            Box(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)
            ) {
                        LazyRow() {
                            itemsIndexed(it) { indice, viento ->
                                if (indice % 2 == 0) {
                                    VientoFila(viento, peticionTiempo2ViewModel)
                                    Spacer(modifier = Modifier.width(16.dp))
                                }

                    }
                }
            }
        }
    }
}
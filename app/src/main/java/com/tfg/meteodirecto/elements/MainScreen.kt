package com.tfg.meteodirecto.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tfg.meteodirecto.database.entities.Favoritos
import com.tfg.meteodirecto.peticion.PeticionDatos2ViewModel
import com.tfg.meteodirecto.peticion.PeticionDatosViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempo2ViewModel
import com.tfg.meteodirecto.peticion.PeticionTiempoViewModel

@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    favoritos: Favoritos,
    peticionDatosViewModel: PeticionDatosViewModel,
    peticionTiempoViewModel: PeticionTiempoViewModel,
    peticionDatos2ViewModel: PeticionDatos2ViewModel,
    peticionTiempo2ViewModel: PeticionTiempo2ViewModel
) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item{
                Tarjeta(peticionDatos2ViewModel, peticionTiempo2ViewModel ,favoritos )
            }
            item{
                Spacer(modifier = Modifier.height(16.dp))
            }
            item{
                ListaFila(peticionDatos2ViewModel, peticionTiempo2ViewModel ,favoritos )
            }
            item{
                Spacer(modifier = Modifier.height(16.dp))
            }
            item{
                Tabla(peticionDatosViewModel, peticionTiempoViewModel ,favoritos)
            }
            item{
                Spacer(modifier = Modifier.height(16.dp))
            }
            item{
                Viento(peticionDatos2ViewModel,peticionTiempo2ViewModel,favoritos)
            }
        }
}

